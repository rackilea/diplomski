final Credential credential = ...
HttpRequestInitializer initializer = new HttpRequestInitializer() {
  public void initialize(HttpRequest request) {
    credential.initialize(request);
    request.connectTimeout = request.readTimeout = 0;
  }
}
Bigquery bigquery = new Bigquery(HTTP_TRANSPORT, JSON_FACTORY, initializer);