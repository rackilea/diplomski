PoolingHttpClientConnectionManager cm = new 
PoolingHttpClientConnectionManager();
cm.setMaxTotal(200);
cm.setDefaultMaxPerRoute(20);
HttpHost localhost = new HttpHost("locahost", 80);
cm.setMaxPerRoute(new HttpRoute(localhost), 50);
CloseableHttpClient httpClient = HttpClients.custom()
    .setConnectionManager(cm)
    .build();