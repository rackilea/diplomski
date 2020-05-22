@Override
public boolean handleMessage(SOAPMessageContext arg0) {
    SOAPMessage message = arg0.getMessage();
    boolean isOutboundMessage = (Boolean) arg0.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if (isOutboundMessage) {
        System.out.println("OUTBOUND MESSAGE");
    } else {
        System.out.println("INBOUND MESSAGE");
    }
    try {
        Source source = message.getSOAPPart().getContent();

        Transformer transformer = TransformerFactory.newInstance().newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        transformer.transform(source, new StreamResult(System.out));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
}