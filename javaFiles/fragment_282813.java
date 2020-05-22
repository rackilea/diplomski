private static void getAliases() throws KeyStoreException,
            FileNotFoundException, NoSuchAlgorithmException,
            CertificateException, IOException {
        if (store.size() == 0)
            System.out.println("Store is Empty!");
        Enumeration<String> enumeration = store.aliases();
        while (enumeration.hasMoreElements()) {
            String alias = (String) enumeration.nextElement();
            System.out.println("Key Alias: " + alias);
        }
    }