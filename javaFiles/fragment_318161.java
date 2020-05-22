public RestRequest(MultivaluedMap<String, Object> myHeaders,TreeMap<String, String> testParameters) {
    this.testParameters = testParameters;
    buildUrl();     
    Client client = ClientBuilder.newClient();

    Set<String> keys = myHeaders.keySet();
    final Map<String, String> testParamsByHeader = new HashMap<>();

    for (String key : keys)
        testParamsByHeader.add(key, testParameters.get(key));
    }
    this.myHeaders = testParamsByHeader;
    myResource = client.target(URL);
    entity=Entity.entity(replaceRequestBodyWithParams(requestBody), MediaType.APPLICATION_JSON);
}