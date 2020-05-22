String payload = "{\"statements\" : [ {\"statement\" : \"" + cypherString + "\"} ]}";
ClientResponse response = resource
        .accept( MediaType.APPLICATION_JSON )
        .type( MediaType.APPLICATION_JSON )
        .entity( payload )
        .post( ClientResponse.class );