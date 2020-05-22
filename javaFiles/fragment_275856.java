public static void main(String[] args) {

    try {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        String url = "http://www.soawebservices.com.br/webservices/producao/cdc/cdc.asmx";
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
        soapResponse.writeTo(System.out);
        //printSOAPResponse(soapResponse);

        soapConnection.close();
    } catch (Exception e) {
        System.err.println("Error occurred while sending SOAP Request to Server");
        e.printStackTrace();
    }

}

private static SOAPMessage createSOAPRequest() throws Exception {
    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String serverURI = "SOAWebServices/PessoaFisicaSimplificada";



    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration("soap", serverURI);


    SOAPBody soapBody = envelope.getBody();
    SOAPElement soapBodyElem = soapBody.addChildElement("PessoaFisicaSimplificada", "","SOAWebServices");
    SOAPElement soapBodyElemC = soapBodyElem.addChildElement("Credenciais");
    SOAPElement soapBodyElem1 = soapBodyElemC.addChildElement("Email");
    soapBodyElem1.addTextNode("EMAIL");
    SOAPElement soapBodyElem2 = soapBodyElemC.addChildElement("Senha");
    soapBodyElem2.addTextNode("PASSWORD");
    SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Documento");
    soapBodyElem3.addTextNode("CPF");
    SOAPElement soapBodyElem4 = soapBodyElem.addChildElement("DataNascimento");
    soapBodyElem4.addTextNode("Date");
    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", serverURI);

    soapMessage.saveChanges();


    System.out.print("Request SOAP Message = ");
    soapMessage.writeTo(System.out);
    System.out.println();

    return soapMessage;
}