private void processInviteResponse(ResponseEvent responseReceivedEvent) throws SipException, InvalidArgumentException {
    Response response = (Response) responseReceivedEvent.getResponse();
    ClientTransaction tid = responseReceivedEvent.getClientTransaction();
    CSeqHeader cseq = (CSeqHeader) response.getHeader(CSeqHeader.NAME);     
    Dialog dialog = responseReceivedEvent.getDialog();

    if (tid == null) {
        // RFC3261: MUST respond to every 2xx
        if (ackRequest!=null && dialog!=null) {
            System.out.println("re-sending ACK");
            dialog.sendAck(ackRequest);
        }
        return;
    }

    if (response.getStatusCode() == Response.OK) {
        System.out.println("Dialog after 200 OK  " + dialog);
        System.out.println("Dialog State after 200 OK  " + dialog.getState());
        ackRequest = dialog.createAck(cseq.getSeqNumber() );
        System.out.println("Sending ACK");
        dialog.sendAck(ackRequest);
    }
}