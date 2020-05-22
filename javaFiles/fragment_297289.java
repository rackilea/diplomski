String path = "rest.asp";
webClient.path(path)
    .type(MediaType.APPLICATION_JSON)
    .accept(MediaType.TEXT_XML_TYPE)
    .query("param1","34")
    .query("param2","88")
    .query("param3","foo")
    .get(Response.class);