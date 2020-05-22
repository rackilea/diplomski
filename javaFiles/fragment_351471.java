getWebServiceTemplate()
.marshalSendAndReceive(
      new JAXBElement<>(new QName(Constants.BROKER_CONNECTION_SERVICE_NAMESPACE_URI, Constants.BROKER_CONNECTION_SERVICE_LOCAL_PART), ConnectionRequestType.class, connectionRequestType),
      new WebServiceMessageCallback() {
      @Override
      public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
      SOAPMessage soapMessage = ((SaajSoapMessage) message).getSaajMessage();
      SOAPHeader soapHeader = soapMessage.getSOAPHeader();

      SOAPHeaderElement actionElement = soapHeader.addHeaderElement(new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing", "Action", "wsa"));
      actionElement.setMustUnderstand(false);
      actionElement.setTextContent("ConnectionService");
    }
});