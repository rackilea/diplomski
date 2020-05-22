public class MyHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public void close(MessageContext context) { 
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        //Don't intercept outbound messages (SOAP Requests)
        if ((Boolean)context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {return true;}

        SOAPMessage message = context.getMessage();
        try {
            SOAPBody body = message.getSOAPBody();
            Iterator<SOAPElement> bodyIterator = body.getChildElements();
            SOAPElement responseElement = bodyIterator.next();
            responseElement.setElementQName(new QName("http://www.theserver.com/cmdb_rel_ci", origGetRecordsResponse.getLocalName(), "cmdb"));
        } catch (Exception e) {e.printStackTrace();}
        return true;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }
}