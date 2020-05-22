HttpClients.custom()
        .addInterceptorLast((HttpResponseInterceptor) (response, context) -> {
            final HttpClientContext clientContext = HttpClientContext.adapt(context);
            final HttpRequest request = clientContext.getRequest();
        })
        .build();