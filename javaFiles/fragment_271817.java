httpTransport = GoogleNetHttpTransport.newTrustedTransport();

KeyStore keyStore = KeyStore.getInstance("PKCS12", "SunJSSE");
keyStore.load(getClass().getResourceAsStream("/ACCESS-KEYS/filename.p12"), "notasecret".toCharArray());
        PrivateKey key = (PrivateKey) keyStore.getKey("privatekey", "notasecret".toCharArray());

credential = new GoogleCredential.Builder().setTransport(httpTransport)
                .setJsonFactory(jsonFactory)
                .setServiceAccountId(SERVICE_ACCOUNT_EMAIL)      
                .setServiceAccountScopes(Collections.singleton(BloggerScopes.BLOGGER))
                .setServiceAccountPrivateKey(key)
                .build();