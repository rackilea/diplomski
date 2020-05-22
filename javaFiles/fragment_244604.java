ClientConfig clientConfig = new ClientConfig();     
Client client = ClientBuilder.newClient(clientConfig);

WebTarget webTarget = client.target("http://example.com/rest");
WebTarget resourceWebTarget = webTarget.path("resource");
WebTarget helloworldWebTarget = resourceWebTarget.path("helloworld");
WebTarget helloworldWebTargetWithQueryParam =
        helloworldWebTarget.queryParam("greeting", "Hi World!");

Invocation.Builder invocationBuilder =
        helloworldWebTargetWithQueryParam.request(MediaType.APPLICATION_JSON_TYPE);
invocationBuilder.header("some-header", "true");

Response response = invocationBuilder.post(Entity.entity("{'my':'json'}", MediaType.APPLICATION_JSON_TYPE));
System.out.println(response.getStatus());
System.out.println(response.readEntity(String.class));