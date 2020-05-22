List<Header> headers = new ArrayList<>();
headers.add(new BasicHeader(HttpHeaders.CONNECTION, "close"));
HttpClientBuilder builder = HttpClients.custom().setDefaultHeaders(headers)
  .setConnectionReuseStrategy(
    new ConnectionReuseStrategy() {
      @Override
      public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        log.info("**** keepAlive strategy returning false");
        return false;
      }
});
CloseableHttpClient httpClient = builder.build();
HttpGet httpGet = new HttpGet("https://google.com");
CloseableHttpResponse response = httpClient.execute(httpGet);
log.info("Response status: " + response.getStatusLine());
response.close();