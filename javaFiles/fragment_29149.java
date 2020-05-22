final GoogleCredential credential = ...;
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
HttpRequestFactory requestFactory = httpTransport.createRequestFactory(
    new HttpRequestInitializer() {
        @Override public void initialize(HttpRequest request) {
            credential.initialize(request);
            request.setReadTimeout(...);
        }
    });