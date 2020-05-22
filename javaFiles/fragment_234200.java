public static HttpComponentsClientHttpRequestFactory buildCustomRequestFactory(String host, int port) throws MoxtraSingleSignOnProcessException {
        HttpComponentsClientHttpRequestFactory requestFactory = null;
        SSLConnectionSocketFactory sslSocketFactory = null;
        SSLContext sslContext = null;
        HttpClient httpClient = null;
        NoopHostnameVerifier hostNameVerifier = new NoopHostnameVerifier();
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();

    try {
        sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustAllStrategy()).useProtocol(SecurityConstants.TLS_V_12).build();
        sslSocketFactory = new SSLConnectionSocketFactory(sslContext, hostNameVerifier);
        clientBuilder.setSSLSocketFactory(sslSocketFactory);

        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register(SecurityConstants.HTTPS, sslSocketFactory)
                .register(SecurityConstants.HTTP, PlainConnectionSocketFactory.getSocketFactory()).build();

        PoolingHttpClientConnectionManager clientConnectionMgr = new PoolingHttpClientConnectionManager(registry);
        HttpHost customHttpHost = new HttpHost(host, port);
        clientConnectionMgr.setSocketConfig(customHttpHost, SocketConfig.custom().setSoTimeout(SOCKET_TIME_OUT).build());

        httpClient = HttpClients.custom().setConnectionManager(clientConnectionMgr).build();
        requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
    } catch (Exception e) {
        throw new MoxtraSingleSignOnProcessException("A problem occured when tried to setup SSL configuration for API call", e);
    }

    return requestFactory;
}