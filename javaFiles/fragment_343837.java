Credential credential = new GoogleCredential.Builder()
    .setClientSecrets(CLIENT_ID, CLIENT_SECRET)
    .setJsonFactory(JSON_FACTORY)
    .setTransport(HTTP_TRANSPORT)
    .build()
    .setAccessToken(yourAccessToken)
    .setRefreshToken(yourRefreshToken);