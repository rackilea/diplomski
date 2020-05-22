private void processRegisterResponse(ResponseEvent responseReceivedEvent) throws TransactionUnavailableException, ParseException, InvalidArgumentException, SipException, NoSuchAlgorithmException {
    Response response = (Response) responseReceivedEvent.getResponse();

    if(response.getStatusCode() == Response.UNAUTHORIZED) {
        sendRegister(response);
    }
    else if (response.getStatusCode() == Response.OK) {
        contactHeader=(ContactHeader)response.getHeader(ContactHeader.NAME);
        sendInvite();
    }               
}