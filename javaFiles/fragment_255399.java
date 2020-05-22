SOAPMessage soapMessage = messageFactory.createMessage();
SOAPPart soapPart = soapMessage.getSOAPPart();
SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
soapEnvelope.addNamespaceDeclaration("atns", AUTOTASK_NAMESPACE);
MimeHeaders soapHeaders = soapMessage.getMimeHeaders();
String authorization = Base64Utils.encodeBasicAuthorization(username, password);
soapHeaders.addHeader("Authorization", "Basic " + authorization);
if (!StringUtils.isBlank(integrationCode)) {
    SOAPElement autotaskIntegrationsElement = soapMessage.getSOAPHeader().addChildElement("AutotaskIntegrations", null, AUTOTASK_NAMESPACE);
    SOAPElement integrationCodeElement = autotaskIntegrationsElement.addChildElement("IntegrationCode");
    integrationCodeElement.setTextContent(integrationCode);
}
SOAPBody soapBody = soapMessage.getSOAPBody();
SOAPElement methodElement = soapBody.addChildElement("query", "atns");
SOAPElement sxmlElement = methodElement.addChildElement("sXML", "atns");
CDATASection query = soapMessage.getSOAPPart().createCDATASection(queryXml));
sxmlElement.appendChild(query);
SOAPMessage soapResponse = soapConnection.call(soapMessage, defaultZoneUrl);