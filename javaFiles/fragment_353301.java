class MyHttpClientBuilder extends HttpClientBuilder {

    @Override
    protected ClientExecChain createMainExec(
            final HttpRequestExecutor requestExec,
            final HttpClientConnectionManager connManager,
            final ConnectionReuseStrategy reuseStrategy,
            final ConnectionKeepAliveStrategy keepAliveStrategy,
            final HttpProcessor proxyHttpProcessor,
            final AuthenticationStrategy targetAuthStrategy,
            final AuthenticationStrategy proxyAuthStrategy,
            final UserTokenHandler userTokenHandler) {

        final HttpProcessor myProxyHttpProcessor = new ImmutableHttpProcessor(new RequestTargetHost(), new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                request.addHeader("Hello", "Mom says hi");
            }
        });

        return super.createMainExec(requestExec, connManager, reuseStrategy, keepAliveStrategy,
                myProxyHttpProcessor, targetAuthStrategy, proxyAuthStrategy, userTokenHandler);
    }
}

HttpClientBuilder httpClientBuilder = new MyHttpClientBuilder();
CloseableHttpClient client = MyHttpClientBuilder.build();