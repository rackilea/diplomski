/**
 * Connect to ESME and submit a message, if binding process fails, reattempt
 * to reconnect and submit.
 */
public void connect() {

    try {
        //Create connection
        BindRequest request = null;
        request = new BindTransciever();
        connection = new TCPIPConnection("localhost", 17632);
        connection.setReceiveTimeout(20 * 1000);
        session = new Session(connection);
        //Prepare request
        request.setSystemId("pavel");
        request.setPassword("wpsd");
        request.setSystemType("CMT");
        request.setInterfaceVersion((byte) 0x34);
        request.setAddressRange(new AddressRange());
        pduListener = new SMPPTestPDUEventListener(session);

        //Session binding process, if it fails, we are thrown to the catch section
        //with a BrokenPipe (IOException)
        session.bind(request, pduListener);

        //Prepare message
        SubmitSM msg = new SubmitSM();
        // set values
        msg.setDestAddr("04234143939");
        msg.setShortMessage("hello");
        msg.assignSequenceNumber(true);

        //Send to our custom made submitMessage method that reattempts if failure
        submitMessage(msg);

    } catch (Exception ex){
            //Analyze what type of exception was
            if (ex instanceof IOException || ex instanceof SocketException){
                //IOException relate to the brokenpipe issue you are facing
                //you need to close existing sessions and connections
                //restablish session
                if (this.connection!=null){
                    this.connection.close();
                }
                //This is a recursive call, I encourage you to elaborate
                //a little bit this method implementing a counter so you
                //don't end up in an infinite loop
                this.connect();
            } else {
                //LOG whatever other exception thrown
            } 
    }
}

    /**
 * Submit message to SMSC, if it fails because of a connection issue, reattempt
 * @param message 
 */
private void submitMessage(SubmitSM message){
        try{
            session.submit(message);
        } catch (Exception ex){
            //Analyze what type of exception was
            if (ex instanceof IOException || ex instanceof SocketException){
                //IOException relate to the brokenpipe issue you are facing
                //you need to close existing sessions and connections
                //restablish session and try to submit again
                if (this.connection!=null){
                    this.connection.close();
                }
                //Call a rebind method
                this.bind();
                //This is a recursive call, I encourage you to elaborate
                //a little bit this method implementing a counter so you
                //don't end up in an infinite loop
                this.submitMessage(message);
            } else {
                //LOG whatever other exception thrown
            }
        }
}