HttpRoutePlanner rp = new DefaultRoutePlanner(DefaultSchemePortResolver.INSTANCE) {

    @Override
    public HttpRoute determineRoute(
            final HttpHost host,
            final HttpRequest request,
            final HttpContext context) throws HttpException {
        HttpHost target = host != null ? host : new HttpHost("some.default.host");
        return super.determineRoute(target, request, context);
    }
};

CloseableHttpClient client = HttpClients.custom()
        .setRoutePlanner(rp)
        .build();