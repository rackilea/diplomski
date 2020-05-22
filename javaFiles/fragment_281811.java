public void processResponse(ResponseEvent responseReceivedEvent) {
    System.out.println("Got a response");
    Response response = (Response) responseReceivedEvent.getResponse();
    CSeqHeader cseq = (CSeqHeader) response.getHeader(CSeqHeader.NAME);

    System.out.println("Response received : Status Code = "
            + response.getStatusCode() + " " + cseq);

    try {
        if(cseq.getMethod().equals(Request.REGISTER)) {
            processRegisterResponse(responseReceivedEvent);
        }
        else if(cseq.getMethod().equals(Request.INVITE)) {
            processInviteResponse(responseReceivedEvent);
        }
        else if(cseq.getMethod().equals(Request.BYE)) {
            processByeResponse(responseReceivedEvent);
        }
        else {
            System.out.println("Response to unexpected request");
        }
    } catch(Exception e)  {
        e.printStackTrace();
    }
}