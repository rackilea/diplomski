String[] transport = {"http", "https"};
    ProxyData data = new ProxyData();
    data.setName(proxyName);
    data.setWsdlURI(*<url to your WSDL>*);
    data.setTransports(transport);
    data.setStartOnLoad(true);       
    data.setEndpointXML("<endpoint xmlns=\"http://ws.apache.org/ns/synapse\"><address uri=\"" + serviceEndPoint + "\" /></endpoint>");
    data.setEnableSecurity(true);
    proxyServiceAdminStub.addProxy(data);