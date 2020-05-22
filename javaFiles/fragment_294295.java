static class Config {

  @Bean
  RestHighLevelClient client() {

    ClientConfiguration clientConfiguration = ClientConfiguration.builder() 
      .connectedTo("localhost:9200", "localhost:9201")
      .build();

    return RestClients.create(clientConfiguration).rest(); 
  }
}

// ...

IndexRequest request = new IndexRequest("spring-data", "elasticsearch", randomID())
  .source(singletonMap("feature", "high-level-rest-client"))
  .setRefreshPolicy(IMMEDIATE);

IndexResponse response = client.index(request);