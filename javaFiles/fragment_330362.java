// create a builder
 HttpClientBuilder builder = HttpClientBuilder.create();

 // optionally configure it to your needs, e.g., 
 builder.disableAutomaticRetries();

 // finally get your HttpClient
 CloseableHttpClient client = builder.build();