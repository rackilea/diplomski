GoogleCredential credential = new GoogleCredential.Builder().setTransport(HTTP_TRANSPORT).setJsonFactory(JSON_FACTORY)
        .setServiceAccountId(confBean.getServiceAccountId()).setServiceAccountScopes("https://spreadsheets.google.com/feeds")
        .setServiceAccountPrivateKeyFromP12File(new File("path to the P12File"))
        .setServiceAccountUser("user@domain.com")
        .build();
SpreadsheetService service = new SpreadsheetService("MySpreadsheetIntegration-v1");
service.setOAuth2Credentials(credential);