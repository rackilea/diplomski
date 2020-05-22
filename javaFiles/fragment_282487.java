public static Map<String, byte[]> cipherAES() throws NoSuchAlgorithmException {
     Map<String, byte[]> aes = new HashMap<String, byte[]>();
     aes.put("IV", createIV(16)); // <-- no need for conversion
     KeyGenerator keyGen = KeyGenerator.getInstance("AES");
     keyGen.init(256);
     Key encryptionKey = keyGen.generateKey();
     aes.put("key", encryptionKey.getEncoded());
     return aes;
}