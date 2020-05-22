public class AsyncServiceTest {
    public AsyncServiceTest(String serviceURI) {
        this.httpClient = HttpAsyncClients.custom().setMaxConnPerRoute(100).setMaxConnTotal(20)
                .setDefaultRequestConfig(RequestConfig.custom().build()).build();

        this.objectMapper = new ObjectMapper();
        this.serviceURI = serviceURI;
    }

    private List<Object> getResults(List<String> queryStrings) throws Exception {
        try {
            httpClient.start();

            final CountDownLatch latch = new CountDownLatch(queryStrings.size());
            final Vector<Object> responses = new Vector<>(queryStrings.size());

            for (String str : queryStrings) {
                // buildUri: In this method we build the absolute request uri.
                httpClient.execute(new HttpGet(buildUri(str)), new FutureCallback<HttpResponse>() {
                    @Override
                    public void completed(HttpResponse response) {
                        try {
                            // mapToLocation: Mapping some Strings to JSON in this method.
                            responses.add(mapToLocation(IOUtils.toString(response.getEntity().getContent(), "UTF-8")));
                            latch.countDown();
                        } catch (IOException e) {
                            failed(e);
                        }
                    }

                    @Override
                    public void failed(Exception e) {
                        logger.error(e.getLocalizedMessage(), e);
                        latch.countDown();
                    }

                    @Override
                    public void cancelled() {
                        logger.error("Request cancelled.");
                        latch.countDown();
                    }
                });
            }

            latch.await();
            return responses;
        } finally {
            httpClient.close();
        }
    }
}