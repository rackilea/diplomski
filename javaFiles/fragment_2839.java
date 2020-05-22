private static Cipher AESCipher = null;
private static Cipher RSACipher = null;

static {
    try {
        AESCipher = Cipher.getInstance("AES");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        e.printStackTrace();
    }
}

static {
    try {
        RSACipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    } catch (NoSuchPaddingException e) {
        e.printStackTrace();
    }
}