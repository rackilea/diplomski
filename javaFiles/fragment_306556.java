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
    soapBody.setAttributeNS(NAMESPACE_WSU, "wsu:Id", id_body);
}