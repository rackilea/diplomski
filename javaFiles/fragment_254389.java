@Test
public void someTest() throws Exception {
    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();

    SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();
    var header = soapEnvelope.getHeader();
    var actionElement = header.addChildElement("Action", "prefix", "http://schemas.xmlsoap.org/ws/2004/08/addressing");
    actionElement.addTextNode("http://cgbridge.rategain.com/2011A/ReservationService/HotelResNotif");

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    soapMessage.writeTo(out);
    System.out.println(new String(out.toByteArray()));
}