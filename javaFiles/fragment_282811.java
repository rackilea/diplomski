public static void createStore(String path, String keyStoreName,
            String storePassword) throws KeyStoreException,
            NoSuchAlgorithmException, CertificateException, IOException {
        KeyStore store = KeyStore.getInstance("BKS");
        char[] password = storePassword.toCharArray();
        store.load(null, password);

        FileOutputStream fos = new FileOutputStream(path + keyStoreName);
        store.store(fos, password);
        System.out.println("New Store Created !");
        fos.close();
    }