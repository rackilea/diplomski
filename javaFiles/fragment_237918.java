public SSLContext sslContext() throws Exception {


        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream in = new FileInputStream(sslTrustStore.getFile());
        keyStore.load(in, sslTrustStorePassword.toCharArray());

        return SSLContextBuilder.create()
                .loadKeyMaterial(keyStore, sslTrustStorePassword.toCharArray(), (a, s)->"alias-name").build();

    }