public boolean handleMessage(SOAPMessageContext context) {
    ...

    SOAPMessage msg = context.getMessage();
    msg.getSoapHeader();
    ...

}