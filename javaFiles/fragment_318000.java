Client client = Client.create()
client.addFilter(new HTTPBasicAuthFilter("neo4j","<mypwd>")); // <-- that's it!
WebResource resource = client.resource(
    "http://localhost:7474/db/data/transaction/commit"
);

ClientResponse response = resource.accept( MediaType.APPLICATION_JSON )
   .type( MediaType.APPLICATION_JSON )
   .post( ClientResponse.class, someStringContainingJsonPayload);