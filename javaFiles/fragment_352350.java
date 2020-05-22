function freeChargeEncryptAES(token){
    var fcKey = "11111111111111111111".substring(0, 16);
    var cipher = crypto.createCipheriv('aes-128-ecb', fcKey, "");
    var encrypted = cipher.update(token,'ascii','hex');
    encrypted += cipher.final('hex');
    return encrypted;
}