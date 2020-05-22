GoogleCredential credential = new GoogleCredential.Builder().setTransport(HTTP_TRANSPORT).setJsonFactory(JSON_FACTORY)
            .setServiceAccountId(confBean.getServiceAccountId()).setServiceAccountScopes("https://www.googleapis.com/auth/drive")
            .setServiceAccountPrivateKeyFromP12File(new File("path to the P12File"))
            .setServiceAccountUser("user@domain.com")
            .build();

    Drive drive = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();