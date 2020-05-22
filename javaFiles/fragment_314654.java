public String decrypt(String encodedJoinedData) throws Exception {

    // Base64-decode the joined data
    byte[] joinedData = Base64.decode(encodedJoinedData); 

    // Get IV and encrypted data
    byte[] iv = new byte[16];
    System.arraycopy(joinedData, 0, iv, 0, iv.length);
    byte[] encryptedData = new byte[joinedData.length - iv.length];
    System.arraycopy(joinedData, iv.length, encryptedData, 0, encryptedData.length);

    // Pad key
    byte[] key = padKey("SiadajerSiadajer".getBytes()); 
    Key aesKey = new SecretKeySpec(key, "AES");

    // Specify CBC-mode
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); 
    IvParameterSpec ivParameterSpec = new IvParameterSpec(iv); 
    cipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);

    // Decrypt data
    byte[] decryptedData = cipher.doFinal(encryptedData);

    // Remove custom padding
    byte[] unpaddedData = unpad(decryptedData);         

    return new String(unpaddedData);
}