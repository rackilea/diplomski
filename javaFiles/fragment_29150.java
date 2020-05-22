final GoogleCredential credential = ...;
HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
HttpRequestFactory requestFactory = httpTransport.createRequestFactory(
    request -> {
        credential.initialize(request);
        request.setReadTimeout(...);
    });