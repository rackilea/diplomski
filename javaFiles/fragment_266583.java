public static GoogleCredential createCredentialForServiceAccountImpersonateUser(
      HttpTransport transport,
      JsonFactory jsonFactory,
      String serviceAccountId,
      Collection<String> serviceAccountScopes,
      File p12File,
      String serviceAccountUser) throws GeneralSecurityException, IOException {
    return new GoogleCredential.Builder().setTransport(transport)
        .setJsonFactory(jsonFactory)
        .setServiceAccountId(serviceAccountId)
        .setServiceAccountScopes(serviceAccountScopes)
        .setServiceAccountPrivateKeyFromP12File(p12File)
        .setServiceAccountUser(serviceAccountUser)
        .build();
  }