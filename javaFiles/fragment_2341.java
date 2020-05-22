function encrypt(payload) {

    //initialize forge random buffer
    var key = forge.random.getBytesSync(16);
    var iv = forge.random.getBytesSync(16);

    let cipher = forge.cipher.createCipher("AES-GCM", key);
    cipher.start({iv : iv});
    cipher.update(forge.util.createBuffer(payload));
    cipher.finish();

    let encrypted = cipher.output.data;
    let tag = cipher.mode.tag.data;
    let encryptedLoad = encrypted+tag;

    // node buffer and forge buffer differ, so the forge buffer must be converted to node Buffer            
    iv = Buffer.from(iv, "binary");
    encryptedLoad = Buffer.from(encryptedLoad, "binary");

    //Calling RSA Encryption
    encryptedKey = RSAencrypt(key);

    return {
     "payload" : base64url(encryptedLoad) ,
     "iv" : base64url(iv),
     "key" : base64url.fromBase64(encryptedKey)
     };
}