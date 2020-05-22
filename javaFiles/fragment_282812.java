static KeyStore loadStore() throws KeyStoreException,
            FileNotFoundException, IOException, NoSuchAlgorithmException,
            CertificateException {

        KeyStore store = KeyStore.getInstance("BKS");

        InputStream keystoreStream = new FileInputStream(keyStoreLocation);
        store.load(keystoreStream, storePassword.toCharArray());
        System.out.println("Key Store loaded!\n");
        return store;
    }