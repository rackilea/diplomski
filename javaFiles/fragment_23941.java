ODataClient client = ODataClientFactory.getClient();

// add the configuration here
client.getConfiguration()
    .setHttpClientFactory(new BasicAuthHttpClientFactory("[username]", "[password]"));

String iCrmServiceRoot = "https://example.dev/Authenticated/Service";
ODataServiceDocumentRequest odClientReq = 
    client.getRetrieveRequestFactory().getServiceDocumentRequest(iCrmServiceRoot)