com.sun.jersey.api.representation.Form input = new Form();
input.add("client_id", "Tyler_Kevin");
input.add("client_secret", "VcwDLMGuFMLnUgqldj.....");
input.add("scope", "http://api.microsofttranslator.com");
input.add("grant_type", "client_credentials");

// send HTTP POST
ClientResponse response = webResource.type("application/x-www-form-urlencoded")
        .post(ClientResponse.class, input);