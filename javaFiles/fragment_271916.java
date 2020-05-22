try {
        AssetManager am = getAssets();
        InputStream inputStream = am.open("key.p12");
        File file = createFileFromInputStream(inputStream);

        credential = new GoogleCredential.Builder().setTransport(TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
                .setServiceAccountScopes(SCOPES)
                .setServiceAccountId("xxxxxxxxxxxxxxxx@developer.gserviceaccount.com")
                .setServiceAccountPrivateKeyFromP12File(file )
                .build();
    } catch (GeneralSecurityException | IOException e1) {
        e1.printStackTrace();
    }