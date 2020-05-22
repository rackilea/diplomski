PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    // Increase max total connection to 200
    cm.setMaxTotal(200);
    // Increase default max connection per route to 20
    cm.setDefaultMaxPerRoute(20);
    // Increase max connections for localhost:80 to 50
    HttpHost localhost = new HttpHost("locahost", 80);
    cm.setMaxPerRoute(new HttpRoute(localhost), 50);

    CloseableHttpClient httpClient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();