/* Copied from HttpComponentsHttpInvokerRequestExecutor */
private static final int DEFAULT_MAX_TOTAL_CONNECTIONS = 100;
private static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 5;
private static final int DEFAULT_READ_TIMEOUT_MILLISECONDS = (60 * 1000);

public CustomHttpComponentsHttpInvokerRequestExecutor() {
    super(makeDefaultHttpClient());
    setReadTimeout(DEFAULT_READ_TIMEOUT_MILLISECONDS);
}

private static HttpClient makeDefaultHttpClient() {
    // New non-deprecated ConnectionManager with same settings as super()
    PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
    connectionManager.setMaxTotal(DEFAULT_MAX_TOTAL_CONNECTIONS);
    connectionManager.setDefaultMaxPerRoute(DEFAULT_MAX_CONNECTIONS_PER_ROUTE);

    // HttpClient with ConnectionManager and no retry
    /*
     * TODO Add a request interceptor that will authenticate 
     * if credentials with AuthScope.ANY are provided.
     */
    HttpClient httpClient = HttpClientBuilder.create().setConnectionManager(connectionManager)
            .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)).build();
    return httpClient;
}

@Override
protected HttpPost createHttpPost(final HttpInvokerClientConfiguration config) throws IOException {
    HttpPost httpPost = super.createHttpPost(config);

    // Set the timeout for this request if it exists.
    Integer timeout = ((CustomHttpInvokerClientConfiguration) config).getReadTimeout();
    if (timeout != null) {
        RequestConfig rConfig = RequestConfig.copy(httpPost.getConfig()).setSocketTimeout(timeout).build();
        httpPost.setConfig(rConfig);
    }

    return httpPost;
}