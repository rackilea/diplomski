// Increase max total connection to 200 and increase default max connection per route to 20. 
// Configure total max or per route limits for persistent connections
// that can be kept in the pool or leased by the connection manager.
PoolingHttpClientConnectionManager oConnectionMgr = new PoolingHttpClientConnectionManager();
oConnectionMgr.setMaxTotal(200);
oConnectionMgr.setDefaultMaxPerRoute(20);
oConnectionMgr.setMaxPerRoute(new HttpRoute(new HttpHost("192.168.20.120", 8080)), 20);

RequestConfig defaultRequestConfig = RequestConfig.custom()
        .setSocketTimeout(5000)
        .setConnectTimeout(5000)
        .setConnectionRequestTimeout(5000)
        .setStaleConnectionCheckEnabled(true)
        .build();

//HttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(defaultRequestConfig).build();
CloseableHttpClient oClientCloseable = HttpClientBuilder.create()
        .setConnectionManager(oConnectionMgr)
        .setDefaultRequestConfig(defaultRequestConfig)
        .build();