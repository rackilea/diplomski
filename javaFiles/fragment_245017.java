HttpClientBuilder builder = HttpClientBuilder.create();
builder = builder.disableContentCompression().disableConnectionState();

builder.addInterceptorLast((HttpRequestInterceptor) (request, context) -> {
    try {
        SignRequest(request, account, secret);
     }
     catch (Exception e) {
     }
});

HttpClient httpclient = builder.build();