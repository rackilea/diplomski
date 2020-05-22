try {
    operationClient.execute(true);
} catch (AxisFault e) {
    LOG.error("Axis Fault error: " + e.getMessage());

    /* we need a new OperationClient, otherwise we'll face the error "A message was added that is not valid. However, the operation context was complete." */
    OperationClient newOperationClient = _serviceClient.createClient(_operations[0].getName());
    newOperationClient.getOptions().setAction(XCPDConstants.SOAP_HEADERS.REQUEST_ACTION);
    newOperationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
    addPropertyToOperationClient(newOperationClient, org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

    SOAPFactory newSoapFactory = getFactory(newOperationClient.getOptions().getSoapVersionURI());

    org.apache.axiom.soap.SOAPEnvelope newEnv;
    newEnv = toEnvelope(newSoapFactory,
                pRPA_IN201305UV02,
                optimizeContent(new javax.xml.namespace.QName(XCPDConstants.SOAP_HEADERS.NAMESPACE_URI, XCPDConstants.SOAP_HEADERS.NAMESPACE_REQUEST_LOCAL_PART)));

    _serviceClient.addHeadersToEnvelope(newEnv);

    /* we create a new Message Context with the new SOAP envelope */
    org.apache.axis2.context.MessageContext newMessageContext = new org.apache.axis2.context.MessageContext();
    newMessageContext.setEnvelope(newEnv);

    /* add the new message contxt to the new operation client */
    newOperationClient.addMessageContext(newMessageContext);
    /* we retry the request */
    newOperationClient.execute(true);
}