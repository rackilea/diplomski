Client client = Client.create();
WebResource webResource = client.resource("http://localhost:8080/input/result");
String input = "<xml></xml>";
ClientResponse response = webResource
    .type("application/xml")
    .put(ClientResponse.class, input);