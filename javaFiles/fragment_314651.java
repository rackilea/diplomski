public String decrypt(String text, String ivEncoded) throws Exception {

    // Pad key
    byte[] key = padKey("SiadajerSiadajer".getBytes()); 
    Key aesKey = new SecretKeySpec(key, "AES");

    // Base64 decode data
    byte[]encryptedData = Base64.decode(text); 

    // Base64 decode iv
    byte[] iv = Base64.decode(ivEncoded);
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv); 

    // Specify CBC-mode
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
    cipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);

    // Decrypt
    byte[] decryptedData = cipher.doFinal(encryptedData);

    // Remove custom padding
    byte[] unpaddedData = unpad(decryptedData);         

    return new String(unpaddedData);
}