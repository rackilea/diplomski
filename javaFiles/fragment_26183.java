public static void main(String[] args) {
    // First I would like to create keys by giving Strings
    SecretKey k1 = generateDESkey();
    SecretKey k2 = generateDESkey();

    // encryption
    byte[] firstEncryption = desEncryption("plaintext".getBytes("UTF-8"), k1, false);
    byte[] decryption = desDecryption(firstEncryption, k2, true);
    byte[] secondEncryption = desEncryption(decryption, k1, true);

    // decryption
    byte[] firstDecryption = desDecryption(secondEncryption, k1, true);
    byte[] encryption = desEncryption(firstDecryption, k2, true);
    byte[] secondDecryption = desDecryption(encryption, k1, false);

    System.out.println(new String(secondDecryption)); // plaintext
}

public static byte[] desEncryption(byte[] strToEncrypt, SecretKey desKey, boolean noPadding) {
    try {
        Cipher cipher = Cipher.getInstance(noPadding ? "DES/ECB/NoPadding" : "DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        return cipher.doFinal(strToEncrypt);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}

public static byte[] desDecryption(byte[] strToDecrypt, SecretKey desKey, boolean noPadding) {
    try {
        Cipher cipher = Cipher.getInstance(noPadding ? "DES/ECB/NoPadding" : "DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        return cipher.doFinal(strToDecrypt);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return null;
}