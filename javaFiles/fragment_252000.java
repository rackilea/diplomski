Client client = ClientBuilder.newClient();
Person person = client.target("http://example.com/api")
                      .path("people").path("1")
                      .request(MediaType.APPLICATION_JSON)
                      .get(Person.class);

String name = person.getName();
Integer age = person.getAge();