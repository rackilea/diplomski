// Create a client
Client client = ClientBuilder.newClient();

// Define a target
WebTarget target = client.target("http://myurl.com/options")
                         .queryParam("value", "3")
                         .queryParam("name", "picture");

// Perform a request to the target
Response response = target.request().header("X-Api-Key", "topsecret")
                          .post(Entity.text(""));

// Process the response
// This part is up to you

// Close the response
response.close();

// Close the client
client.close();