private static final List<String> SCOPES =
            Arrays.asList(DriveScopes.DRIVE);
     @Override
        public Credential authorize() throws IOException {
            InputStream in =
                    DriveQuickstartImpl.class.getResourceAsStream("/client_secret.json");
            GoogleClientSecrets clientSecrets =
                    GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            GoogleAuthorizationCodeFlow flow =
                    new GoogleAuthorizationCodeFlow.Builder(
                            HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                            .setDataStoreFactory(DATA_STORE_FACTORY)
                            .setAccessType("online").setApprovalPrompt("auto")
                            .build();
            Credential credential = new AuthorizationCodeInstalledApp(
                    flow, new LocalServerReceiver()).authorize("user");
            if(credential!=null && credential.getRefreshToken() != null){
                storeCredentials(credential);
            }
           return credential;

        }