public String loadTable(String tablename) throws ClientProtocolException, IOException {
    pathParams.add("tablename", tablename);
    ClientResponse response = service.path("access").path("loadtable").queryParams(pathParams).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
    String responseString = response.getEntity(String.class);
    return responseString;
}