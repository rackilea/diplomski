function createCipherCommon(text, alg, key, iv) {
    var cipher = crypto.createCipheriv(alg, key, iv);
    cipher.setAAD(Buffer.from("aad", 'utf8'));
    return {
        encwithtag: Buffer.concat([cipher.update(text, 'utf8'), cipher.final(), cipher.getAuthTag()]).toString('base64')
    };
}