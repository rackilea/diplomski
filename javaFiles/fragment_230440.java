static Cipher cipher;
    static KeyPairGenerator keyPairGenerator;
    static KeyPair keyPair;
    static String message = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";

    public static void main(String[] ars) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, IOException, BadPaddingException {
        keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPair = keyPairGenerator.generateKeyPair();
        cipher = Cipher.getInstance("RSA");
        decryptIt(encryptIt());
    }

    static byte[] encryptIt() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        System.out.println("Size:"+message.getBytes().length);
        return cipher.doFinal(message.getBytes());
    }

    static void decryptIt(byte[] encryptedMessage) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        System.out.println("Decrypted Msg : "+new String(cipher.doFinal(encryptedMessage)));
    }