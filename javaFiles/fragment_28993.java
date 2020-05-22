RequestConfig.Builder requestBuilder = RequestConfig.custom();
requestBuilder.setConnectTimeout(timeout);
requestBuilder.setConnectionRequestTimeout(timeout);

HttpClientBuilder builder = HttpClientBuilder.create();     
builder.setDefaultRequestConfig(requestBuilder.build());
HttpClient client = builder.build();