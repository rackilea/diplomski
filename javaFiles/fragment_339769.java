class HttpFetcher {
  private final ConnectionCreator connectionCreator;

  ...

  public HttpFetcher(ConnectionCreator connectionCreator) { this.connectionCreator = connectionCreator; }
  public String get(...) {
    ...
    try {
      connection = connectionCreator.createConnectionForUrl(url);
      ...