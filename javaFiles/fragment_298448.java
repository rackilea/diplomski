String base64Text="";
try {
    String key = "MyEncryptionKey";
    byte[] keyBytes = key.getBytes("UTF-8");
    byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };
    byte[] cipherData;

    //############## Request(crypt) ##############
    cipherData = AES256Cipher.encrypt(ivBytes, keyBytes, passval1.getBytes("UTF-8"));
    base64Text = Base64.encodeToString(cipherData, Base64.DEFAULT);
}
catch ( Exception e ) {
    e.printStackTrace();
}