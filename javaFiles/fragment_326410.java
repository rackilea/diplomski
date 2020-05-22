CloseableHttpClient client = HttpClients.custom()
        .setServiceUnavailableRetryStrategy(new ServiceUnavailableRetryStrategy() {
            @Override
            public boolean retryRequest(
                    final HttpResponse response, final int executionCount, final HttpContext context) {
                int statusCode = response.getStatusLine().getStatusCode();
                return statusCode == 403 && executionCount < 5;
            }

            @Override
            public long getRetryInterval() {
                return 0;
            }
        })
        .build();