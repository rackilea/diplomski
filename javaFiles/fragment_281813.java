private void sendInvite() throws ParseException, InvalidArgumentException, TransactionUnavailableException, SipException {

    // create To Header
    URI toAddress = addressFactory.createURI(calledURI);
    Address toNameAddress = addressFactory.createAddress(toAddress);
    ToHeader toHeader = headerFactory.createToHeader(toNameAddress,null);

    FromHeader fromHeader = headerFactory.createFromHeader(fromNameAddress, "12345");
    // Create ViaHeaders
    ArrayList<ViaHeader> viaHeaders = getViaHeaders();

    // Create a new CallId header
    CallIdHeader callIdHeader = sipProvider.getNewCallId();

    // Create a new Cseq header
    CSeqHeader cSeqHeader = headerFactory.createCSeqHeader(cseq,Request.INVITE);
    cseq++;

    // Create a new MaxForwardsHeader
    MaxForwardsHeader maxForwards = headerFactory.createMaxForwardsHeader(70);

    // Create the request.
    Request request = messageFactory.createRequest(toAddress,
            Request.INVITE, callIdHeader, cSeqHeader, fromHeader,
            toHeader, viaHeaders, maxForwards);

    request.addHeader(contactHeader);

    // at this point you should add the rest of the headers, content, etc.

    // Create the client transaction.
    ClientTransaction currentTid = sipProvider.getNewClientTransaction(request);
    // send the request out.
    currentTid.sendRequest();
}