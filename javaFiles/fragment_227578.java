int bufferSize = 42;
ConnectionConfig config = ConnectionConfig.custom().setBufferSize(bufferSize).build();

CloseableHttpClient httpClient = HttpClientBuilder.create()
                                    .setDefaultConnectionConfig(config)
                                    .build();