public class MyHandler<SOAPMessageContext> implements Handler {

    public boolean handleMessage(SOAPMessageContext c) {
        if((Boolean)c.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) {
            c.put(SOAPMessageContext.HTTP_RESPONSE_HEADERS,"your header stuff here");
            return true;
        }
    }
 }