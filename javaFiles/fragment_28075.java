public static Credential getCredential() throws IOException {
        if (credential == null) {
            InputStream is = GoogleSheetsCredential.class
              .getResourceAsStream("/sheets-service-account.json");
            credential = GoogleCredential.fromStream(is)
              .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
        }
        return credential;
    }