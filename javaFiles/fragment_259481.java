private static SOAPMessage createSOAPRequest(String documentId,
    String fileToUpdate) throws Exception { 
  MessageFactory messageFactory = MessageFactory.newInstance();
  SOAPMessage soapMessage = messageFactory.createMessage();
  SOAPPart soapPart = soapMessage.getSOAPPart();
  String serverURI = "urn:WSFS";                      // change form "WSFS" to "urn:WSFS"
  SOAPEnvelope envelope = soapPart.getEnvelope();

  envelope.addNamespaceDeclaration("urn", serverURI); // this line will add namespece in your envelope

  ...