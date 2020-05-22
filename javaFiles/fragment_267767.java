SSLContextBuilder builder = new SSLContextBuilder();
builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
        builder.build());
CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(
        sslsf).build();

HttpGet httpGet = new HttpGet("https://some-server");
CloseableHttpResponse response = httpclient.execute(httpGet);
try {
    System.out.println(response.getStatusLine());
    HttpEntity entity = response.getEntity();
    EntityUtils.consume(entity);
} finally {
    response.close();
}