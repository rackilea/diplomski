HandlerInfo hi;

public void init(HandlerInfo info) {
    hi = info;
}

public QName[] getHeaders() {
    return hi.getHeaders();
}

public boolean handleResponse(MessageContext context) {

    return true;
}

/**
 * This method is use to add custom headers to existing SAOP request
 */
public boolean handleRequest(MessageContext context) {
    System.out.println("response");

    try {
        SOAPMessageContext smc = (SOAPMessageContext) context;
        SOAPMessage message = smc.getMessage();
        MimeHeaders hd = message.getMimeHeaders();
        hd.addHeader("Authorization", "Basic some credentials");

    } catch (Exception e) {
        throw new JAXRPCException(e);
    }
    return true;
}