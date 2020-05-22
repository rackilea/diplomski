public static String decrypt(String hashKey, String hashIv, String value) {
    try {
        SecretKeySpec skeySpec = new SecretKeySpec(hashKey.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(hashIv.getBytes("UTF-8"));
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] decrypted = cipher.doFinal(HexToBytes(value));
        byte[] unpadded = removePKCS7Padding(decrypted);
        return new String(unpadded, "UTF-8");
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return null;
}