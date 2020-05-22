String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns2:consultaCEPResponse xmlns:ns2=\"http://cliente.bean.master.sigep.bsb.correios.com.br/\"><return><bairro>Asa Norte</bairro><cep>70002900</cep><cidade>Brasilia</cidade><complemento /><complemento2 /><end>SBN Quadra 1 Bloco A</end><id>0</id><uf>DF</uf></return></ns2:consultaCEPResponse></soap:Body></soap:Envelope>";
SOAPMessage rp = MessageFactory.newInstance().createMessage(null, new ByteArrayInputStream(xml.getBytes()));

NodeList returnNodes = rp.getSOAPBody().getElementsByTagName("return");
if (returnNodes.getLength() == 1) {
    Node returnNode = returnNodes.item(0);
    NodeList elements = returnNode.getChildNodes();
    for (int i = 0; i < elements.getLength(); i++) {
        Node node = elements.item(i);
        System.out.println(node.getNodeName() + " = " + node.getTextContent());
    }
} else {
    // handle empty response case
}