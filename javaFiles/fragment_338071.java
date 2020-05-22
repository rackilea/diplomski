class ApplicationTest
    public void checkIfEventCreatedMsgIsSent() {
        Application.createNewEvent("Id101");
        // Wait till the application sends message to the client
        // And then check that the message sent is the correct one
        // if (expectedMessage == recievedMessageFromClient) {
        //   success();
        // }
        int iCount = 0;
        int final MAXCOUNT = 5;
        // Assuming client doesnt send an acknowledgement 
            // but Server pools to find that
        // Below is Polling code method to check if  event is created
        // Servlet context is an example
            // it could be a persistent message on MQ or a value in db
        while(iCount < 5) {
             if (servletcontext.get(msg).get("Id101") == null) {
                 count++;
                 sleep(5000);
             } else { System.out.println("Eureka, msg is sent!")}
        }
    }
class Client{
   public void readMessage(Message message) {
        // Received the new event message with Id101
        // Now this message should be sent to 
            // ApplicationTest.checkIfEventCreatedMsgIsSent and confirmed by it
        // Below msg is a singleton object in Servlet context as an example
            // it could be a persistent message on MQ or a value in db
        // Map<String, Object> msg = new HashMap<String, Object>();
        synchronized(servletContext) {
            servletcontext.get(msg).put("Id101", <object>);
        }
    }
}