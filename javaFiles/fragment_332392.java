final Client client = new Client();
        final WebResource webResource = client.resource("http://abc/springrestexample/employees");
        final ClientResponse response = webResource.accept("application/json").header("KEY", "Value" ).get(ClientResponse.class);
        if (response.getStatus() != 200)
        {
            throw new RuntimeException("Failed Http Error code " + response.getStatus());
        }
        final String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);