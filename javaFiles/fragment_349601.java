SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
        SSLContext.getDefault(),
        new String[] {"TLSv1"},
        null,
        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", socketFactory)
        .build();

PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();
try (CloseableHttpResponse response = client.execute(new HttpGet("https://www.ethz.ch/de.html"))) {
    System.out.println(response.getStatusLine());
    System.out.println(EntityUtils.toString(response.getEntity()));
}