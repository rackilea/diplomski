HttpClient apacheClient = HttpClientBuilder.create().build();
Client client = new Client(new ApacheHttpClient4Handler(apacheClient,
                                                        new BasicCookieStore(),
                                                        true));
WebResource webResource = client.resource("http://localhost:8080/path");
ClientResponse response = webResource.accept("application/json")
                                     .get(ClientResponse.class);