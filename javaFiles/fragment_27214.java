public boolean handleMessage(SOAPMessageContext context) {

    boolean isResponse = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    try {
        if (!isResponse) {
            SOAPMessage msg = context.getMessage();
            SOAPBody body = msg.getSOAPBody();
            Iterator<?> iter = body.getChildElements();
            while (iter.hasNext()) {
                Object next = iter.next();
                if (next instanceof SOAPElement) {
                    SOAPElement se = (SOAPElement) next;
                    if (se.getNamespaceURI().equalsIgnoreCase("http://service.plr.mycomp.com/BruttoNettoRechner/1.0")) {
                        QName qName = new QName("http://service.plr.mycomp.com", "calculateBruttoNetto", "impl");
                        se.setElementQName(qName);
                        break;
                    }
                }
            }
            if (msg.saveRequired()) {
                msg.saveChanges();
            }
            // msg.writeTo(System.out);

        }
    } catch (SOAPException e) {
        log.error("Fehler beim Bearbeiten des Requests im ServerSOAPHandler", e);
    }

    return true;
}