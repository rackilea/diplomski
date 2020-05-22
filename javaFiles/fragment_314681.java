//try-with-resources
            try (CloseableHttpClient client = HttpClientBuilder
                    .create()
                    .setDefaultRequestConfig(requestConfig)
                    .build()){
                response = client.execute(new HttpGet(routingRequestUrl));
            stopWatch.stop();
//            String latencyMsg = "after sending http. client-latency: "+stopWatch.elapsed(TimeUnit.MILLISECONDS) +" server-latency: "+response.getHeaders("Latency")[0].getValue();

            logUtils.addLongToLongStatisticCollector("http.client.latency", (int)stopWatch.elapsed(TimeUnit.MILLISECONDS));
            logUtils.addLongToLongStatisticCollector("http.server.latency", Integer.parseInt(response.getHeaders("Latency")[0].getValue()));

            answer = analyzeStatusCodeAndMsgBody(numberOfTriesLeft, routingRequestUrl, answer, response, stopWatch);
            }