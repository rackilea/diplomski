YAMLMapper mapper = new YAMLMapper();
Client client = ClientBuilder.newClient();

Response response = client.target("http://example.org")
        .request().accept("application/x-yml")
        .post(Entity.entity(mapper.writeValueAsString(foo), "application/x-yml"));