public EngineConfiguration createConfigurationWithSecurityHeaders(Merchant merchant) throws Exception {
    SimpleProvider result;

    Handler securityHandler;
    SimpleChain requestHandler;
    SimpleChain responseHandler;
    Handler pivot;
    Handler transport;

    try {
        result = new SimpleProvider();

        securityHandler = new WSDoAllSender();
        securityHandler.setOption(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
        securityHandler.setOption(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        securityHandler.setOption(WSHandlerConstants.USER, merchant.toString());
        securityHandler.setOption(WSHandlerConstants.MUST_UNDERSTAND, "false");

        requestHandler = new SimpleChain();
        requestHandler.addHandler(securityHandler);

        responseHandler = new SimpleChain();
        responseHandler.addHandler(securityHandler);

        pivot = new HTTPSender();

        transport = new SimpleTargetedChain(requestHandler, pivot, responseHandler);

        result.deployTransport(HTTPTransport.DEFAULT_TRANSPORT_NAME, transport);
    }
    catch (Exception e) {
        throw e;
    }

    return result;
}

public ReplyMessage post (Merchant merchant, RequestMessage request) throws Exception {
    ReplyMessage result;

    TransactionProcessorLocator locator;
    URL endPoint;
    ITransactionProcessorStub stub;
    EngineConfiguration configuration;

    try {
        locator = new TransactionProcessorLocator();

        // use client config
        configuration = createConfigurationWithSecurityHeaders(merchant);
        locator.setEngineConfiguration(configuration);
        locator.setEngine(new org.apache.axis.client.AxisClient(configuration));

        endPoint = new URL(environment.getUrl());

        stub = (ITransactionProcessorStub) locator.getportXML(endPoint);
        stub._setProperty(WSHandlerConstants.PW_CALLBACK_REF, this);

        result = stub.runTransaction(request);
    }
    catch (Exception e) {
        throw e;
    }

    return result;
}