public Credential authorize() throws IOException {
    InputStream in = GoogleLogin.class.getResourceAsStream("/google/client_secret.json");
    GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
    // Build flow and trigger user authorization request.
    flow = new GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
            .setDataStoreFactory(DATA_STORE_FACTORY)
            .setAccessType("offline")
            .setCredentialCreatedListener(new AuthorizationCodeFlow.CredentialCreatedListener() {
                @Override
                public void onCredentialCreated(Credential credential, TokenResponse tokenResponse) throws IOException {
                    DATA_STORE_FACTORY.getDataStore("user").set("id_token", tokenResponse.get("id_token").toString());
                }
            })
            .addRefreshListener(new CredentialRefreshListener() {
                @Override
                public void onTokenResponse(Credential credential, TokenResponse tokenResponse) throws IOException {
                    DATA_STORE_FACTORY.getDataStore("user").set("id_token", tokenResponse.get("id_token").toString());
                }

                @Override
                public void onTokenErrorResponse(Credential credential, TokenErrorResponse tokenErrorResponse) throws IOException {
                    //handle token error response
                }
            })
            .build();

    Credential credential = new AuthorizationCodeInstalledApp(flow, serverReceiver).authorize("user");
    System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
    return credential;
}