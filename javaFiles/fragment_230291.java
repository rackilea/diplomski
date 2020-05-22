CloseableHttpClient client = HttpClients.createSystem();
RequestConfig requestConfig = RequestConfig.custom().setNormalizeUri(false).build();
HttpClientContext clientContext = HttpClientContext.create();
clientContext.setRequestConfig(requestConfig);
try (CloseableHttpResponse response = client.execute(
        new HttpGet("https://www.encodeproject.org/files/ENCFF784GFP/@@download/ENCFF784GFP.hic"),
        clientContext)) {
    System.out.println(response.getStatusLine());
    HttpEntity entity = response.getEntity();
    EntityUtils.consume(entity);
}

HTTP/1.1 200 OK