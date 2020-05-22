public static String printSoapMessage(final SOAPMessage soapMessage) throws TransformerFactoryConfigurationError,
        TransformerConfigurationException, SOAPException, TransformerException
{
    final TransformerFactory transformerFactory = TransformerFactory.newInstance();
    final Transformer transformer = transformerFactory.newTransformer();

    // Format it
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

    final Source soapContent = soapMessage.getSOAPPart().getContent();

    final ByteArrayOutputStream streamOut = new ByteArrayOutputStream();
    final StreamResult result = new StreamResult(streamOut);
    transformer.transform(soapContent, result);

    return streamOut.toString();
}