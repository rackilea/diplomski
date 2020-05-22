Version version = commonClient.authorizedRequestBuilder(commonClient.webTarget
        .path("/apps/blabla/default/" + appName + "/" + appName)
        .queryParam("object_type", "app"))
        .accept(MediaType.APPLICATION_JSON_TYPE)
        .get(ClientResponse.class)
        .getEntity();