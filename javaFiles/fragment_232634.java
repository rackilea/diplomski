public void uploadFileUsingSwA(String fileName) throws Exception {

    Options options = new Options();
    options.setTo(targetEPR);
    options.setProperty(Constants.Configuration.ENABLE_SWA, Constants.VALUE_TRUE);
    options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
    options.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    options.setTo(targetEPR);

    ServiceClient sender = new ServiceClient(null,null);
    sender.setOptions(options);
    OperationClient mepClient = sender.createClient(ServiceClient.ANON_OUT_IN_OP);

    MessageContext mc = new MessageContext();   
    mc.setEnvelope(createEnvelope());
    FileDataSource fileDataSource = new FileDataSource("test-resources/mtom/test.jpg");
    DataHandler dataHandler = new DataHandler(fileDataSource);
    mc.addAttachment("FirstAttachment",dataHandler);

    mepClient.addMessageContext(mc);
    mepClient.execute(true);
}