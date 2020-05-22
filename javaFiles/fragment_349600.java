SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
        SSLContext.getDefault(),
        new String[] { "SSLv2Hello","SSLv3","TLSv1","TLSv1.1","TLSv1.2"},
        null,
        SSLConnectionSocketFactory.getDefaultHostnameVerifier());
Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.getSocketFactory())
        .register("https", socketFactory)
        .build();

PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();