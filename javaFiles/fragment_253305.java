HttpClientBuilder builder = HttpClients.custom()
        .disableConnectionState()
        .disableCookieManagement();

if( useProxy )
    builder = builder.setProxy(new HttpHost(proxyServerAddress, proxyServerPort));

CloseableHttpClient httpClient = builder.build();