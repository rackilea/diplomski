public List<Stock> getStockList() {
    WebResource resource = Client.create().resource(server.uri());
    ClientResponse clientResponse =
        resource.path("stock")
        .type(MediaType.APPLICATION_JSON)
        .get(ClientResponse.class);
    return clientResponse.getEntity(new GenericType<List<Stock>>() {
    });
}