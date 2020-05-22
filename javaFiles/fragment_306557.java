/**
 * Asigna un identificador único al nodo Body del mensaje.
 * 
 * @param soapMessage                       Mensaje SOAP
 * 
 * @throws SOAPException
 */
private static void asignarIdNodoBody(SOAPMessage soapMessage) throws SOAPException {
    String idBody = "Body-123456";
    SOAPBody soapBody = soapMessage.getSOAPBody();
    SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
    Name name = soapEnvelope.createName("Id", "wsu", NAMESPACE_WSU);

    soapBody.addAttribute(name, id_body);
}