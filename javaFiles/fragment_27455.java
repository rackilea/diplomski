ClientConfig config = new DefaultClientConfig();
Client client = Client.create(config);
WebResource service = client.resource(getBaseURI());
ClientResponse response = service.path(ADDRESS).type("application/json").get(ClientResponse.class);
String s = response.getEntity(String.class);
System.out.println(s); 

private static URI getBaseURI() {
        return UriBuilder.fromUri(SERVER ADDRESS).build();
}