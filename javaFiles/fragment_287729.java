ClientResponse response = webResource.header("Accept", "application/json; application/vnd.esios-api-v1+json")
                .header("Content-Type", "application/json")
                .header("Host", "api.esios.ree.es")
                .header("Authorization", "Token token=\"TOKEN\"")
                .header("Cookie", " ")
                .get(ClientResponse.class);