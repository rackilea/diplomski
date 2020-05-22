PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
connectionManager.setMaxTotal(60);
connectionManager.setDefaultMaxPerRoute(6);

try (CloseableHttpClient client = HttpClients.custom().setConnectionManager(connectionManager).build()) {

    HttpGet request = new HttpGet("http://www.google.com/search?q=httpClient");
    request.setHeader("User-Agent", "HttpClient");
    try (CloseableHttpResponse response = client.execute(request)) {
        MediaType mediaType = MediaType.parseMediaType(response.getFirstHeader("Content-Type").getValue());
        Charset charSet = mediaType.getCharSet();
        HttpEntity entity = response.getEntity();
        InputStream is = entity.getContent();
        String body = CharStreams.toString(new InputStreamReader(is, charSet));
        System.out.println("body = " + body);
        EntityUtils.consume(entity);
    }
}