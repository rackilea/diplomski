final String tokenValue = "something";

restClient.getInterceptors().add(new ClientHttpRequestInterceptor() {

    @Override
    ClientHttpResponse intercept(HttpRequest request,
                         byte[] body,
                         ClientHttpRequestExecution execution)
                         throws java.io.IOException {

        URI modifiedUri = UriComponentsBuilder.fromUri(request.getURI())
        .query("token={tokenPlaceholder}")
        .buildAndExpand(tokenValue)
        .toUri();

        request.setURI(modifiedUri);
    }
});