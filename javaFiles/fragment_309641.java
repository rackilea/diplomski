private static GoogleCredential getGoogleCredential() throws IOException {
    List<String> scopes = new ArrayList<String>();
    scopes.add(AndroidPublisherScopes.ANDROIDPUBLISHER);

    ClassLoader classLoader = MY_CLASS.class.getClassLoader();
    GoogleCredential credential = GoogleCredential.fromStream(classLoader.getResourceAsStream(GOOGLE_KEY_FILE_PATH))
            .createScoped(scopes);
    return credential;
}

private static ProductPurchase getPurchase(GoogleReceipt receipt, GoogleCredential credential)
        throws GeneralSecurityException, IOException {
    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
    JsonFactory jsonFactory = new JacksonFactory();
    AndroidPublisher publisher = new AndroidPublisher.Builder(httpTransport, jsonFactory, credential)
            .setApplicationName(YOUR_APPLICATION_NAME).build();
    AndroidPublisher.Purchases purchases = publisher.purchases();

    final Get request = purchases.products().get(receipt.getPackageName(), receipt.getProductId(),
            receipt.getPurchaseToken());
    final ProductPurchase purchase = request.execute();
    return purchase;
}