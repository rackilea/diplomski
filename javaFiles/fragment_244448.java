GoogleCredential credential = new GoogleCredential.Builder()
        .setTransport(new NetHttpTransport())
        .setJsonFactory(new JacksonFactory())
        .setClientSecrets("client_id", "client_secret")
        .build();

credential.setAccessToken("access_token");