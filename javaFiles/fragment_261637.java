public static void main(String[] args) {
    try (
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Felipe\\ks");
    ) {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Certificate[] chain = {generateCertificate("cn=Unknown", keyPair, 365, "SHA256withRSA")};

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setKeyEntry("main", keyPair.getPrivate(), "654321".toCharArray(), chain);
        keyStore.store(fos, "123456".toCharArray());
    } catch (IOException | GeneralSecurityException e) {
        e.printStackTrace();
    }
}