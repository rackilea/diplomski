final SalesOrderServiceSoap salesOrderServiceSoap = new SalesOrderService(url).getSalesOrderServiceSoap(); //The service you need to use
    final Client cl = ClientProxy.getClient(salesOrderServiceSoap);
    final HTTPConduit httpConduit = (HTTPConduit) cl.getConduit();
    final HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();

    httpClientPolicy.setConnectionTimeout(CONNECTION_TIMEOUT); //Time in milliseconds
    httpClientPolicy.setReceiveTimeout(RECEIVE_TIMEOUT); //Time in milliseconds
    httpConduit.setClient(httpClientPolicy);