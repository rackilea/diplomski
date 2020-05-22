public class DuplicateDetectingSOAPHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if (isDuplicate(context)) {
            MessageFactory messageFactory;
                try {
                    messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
                    SOAPMessage message = messageFactory.createMessage();
                    // detaching the SOAPBody violates api and causes an error
                    message.getSOAPBody().detachNode();
                    context.setMessage(message);
                } catch (SOAPException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            return false;
        }
        return true;
    }

    private boolean isDuplicate(SOAPMessageContext context) {
        // determine if message is duplicate
    }