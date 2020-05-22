/*
    Elasticsearch Configuration
*/
List<HttpHost> httpHosts = new ArrayList<>();
httpHosts.add(new HttpHost("127.0.0.1", 9200, "http"));

// use a ElasticsearchSink.Builder to create an ElasticsearchSink
ElasticsearchSink.Builder<ObjectNode> esSinkBuilder = new ElasticsearchSink.Builder<>(
        httpHosts,
        new ElasticsearchSinkFunction<ObjectNode>() {
            private IndexRequest createIndexRequest(ObjectNode payload) {

                // remove the value node so the fields are at the base of the json payload
                JsonNode jsonOutput = payload.get("value");

                return Requests.indexRequest()
                        .index("raw-payload")
                        .type("payload")
                        .source(jsonOutput.toString(), XContentType.JSON);
            }

            @Override
            public void process(ObjectNode payload, RuntimeContext ctx, RequestIndexer indexer) {
                indexer.add(createIndexRequest(payload));
            }
        }
);

// set number of events to be seen before writing to Elasticsearch
esSinkBuilder.setBulkFlushMaxActions(1);

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

// finally, build and add the sink to the job's pipeline
stream.addSink(esSinkBuilder.build());