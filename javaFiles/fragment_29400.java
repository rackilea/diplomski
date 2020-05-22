ClientResponse response = webResource
                .accept(MediaType.APPLICATION_JSON)
                .header("X-Parse-Application-Id", "XXXXXXXXXXXXXXXXXXXXXXXXXX")
                .header("X-Parse-REST-API-Key", "XXXXXXXXXXXXXXXXXXXXXXXXX")
                .type(MediaType.APPLICATION_JSON)
                .post(ClientResponse.class, postDataAsStr);