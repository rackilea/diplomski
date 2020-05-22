function encrypt(plaintext, password){
    var iv = CryptoJS.lib.WordArray.random(128/8);
    var key = CryptoJS.enc.Hex.parse(CryptoJS.SHA1(password).toString().substring(0,32));
    var ct = CryptoJS.AES.encrypt(plaintext, key, { iv: iv });
    return iv.concat(ct.ciphertext).toString();
}

console.log("ct: " + encrypt("plaintext", "test"));