private HttpClientConnectionManager createConnectionManager(
        final Configuration config,
        SSLContext sslContext,
        X509HostnameVerifier hostnameVerifier,
        boolean useSystemProperties) {

    final String[] supportedProtocols = useSystemProperties ? StringUtils.split(
            System.getProperty("https.protocols")) : null;
    final String[] supportedCipherSuites = useSystemProperties ? StringUtils.split(
            System.getProperty("https.cipherSuites")) : null;

    if (hostnameVerifier == null) {
        hostnameVerifier = SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    }

    LayeredConnectionSocketFactory sslSocketFactory;
    if (sslContext != null) {
        sslSocketFactory = new SSLConnectionSocketFactory(
                sslContext, supportedProtocols, supportedCipherSuites, hostnameVerifier);
    } else {
        if (useSystemProperties) {
            sslSocketFactory = new SSLConnectionSocketFactory(
                    (SSLSocketFactory) SSLSocketFactory.getDefault(),
                    supportedProtocols, supportedCipherSuites, hostnameVerifier);
        } else {
            sslSocketFactory = new SSLConnectionSocketFactory(
                    SSLContexts.createDefault(),
                    hostnameVerifier);
        }
    }

    final Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
         .register("http", PlainConnectionSocketFactory.getSocketFactory())
         .register("https", sslSocketFactory)
         .build();

    final PoolingHttpClientConnectionManager connectionManager =
            new PoolingHttpClientConnectionManager(registry);

    if (useSystemProperties) {
        String s = System.getProperty("http.keepAlive", "true");
        if ("true".equalsIgnoreCase(s)) {
            s = System.getProperty("http.maxConnections", "5");
            final int max = Integer.parseInt(s);
            connectionManager.setDefaultMaxPerRoute(max);
            connectionManager.setMaxTotal(2 * max);
        }
    }

    return connectionManager;
}