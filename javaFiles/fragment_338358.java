GoogleCredential credential = new GoogleCredential.Builder()
    .setTransport(httpTransport)
    .setJsonFactory(JSON_FACTORY)
    .setServiceAccountId("service-account@email-address") // Service account email
    .setServiceAccountPrivateKeyFromP12File(new File("your-credentials.p12"))
    .setServiceAccountScopes(Collections.singleton(CalendarScopes.CALENDAR))
    .setServiceAccountUser("user@email-address") // Your email address (address of the user you want to impersonate)
    .build();