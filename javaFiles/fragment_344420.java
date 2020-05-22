// provide a RestClientFactory for custom configuration on the internally created REST client
esSinkBuilder.setRestClientFactory(
    restClientBuilder -> {
        restClientBuilder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {

                // elasticsearch username and password
                CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("$USERNAME", "$PASSWORD"));

                return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            }
        });
    }
);