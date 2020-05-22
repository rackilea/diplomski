@Bean
public WebFilter httpsRedirectFilter() {
    return new WebFilter() {
        @Override
        public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
            URI originalUri = exchange.getRequest().getURI();

            //here set your condition to http->https redirect
            List<String> forwardedValues = exchange.getRequest().getHeaders().get("x-forwarded-proto");
            if (forwardedValues != null && forwardedValues.contains("http")) {
                try {
                    URI mutatedUri = new URI("https",
                            originalUri.getUserInfo(),
                            originalUri.getHost(),
                            originalUri.getPort(),
                            originalUri.getPath(),
                            originalUri.getQuery(),
                            originalUri.getFragment());
                    ServerHttpResponse response = exchange.getResponse();
                    response.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
                    response.getHeaders().setLocation(mutatedUri);
                    return Mono.empty();
                } catch (URISyntaxException e) {
                    throw new IllegalStateException(e.getMessage(), e);
                }
            }
            return chain.filter(exchange);
        }
    };
}