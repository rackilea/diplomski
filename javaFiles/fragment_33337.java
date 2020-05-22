public class Client {
    private final Consumer<String> messageConsumer;

    public Client( String ip, int port, Consumer<String>  messageConsumer) throws IOException {
        this.messageConsumer = messageConsumer;
        Thread recievingRoutineThread = new Thread( new Runnable() {
            @Override
            public void run() {
                while(true) {
                    String recievingString = null;
                    try{ recievingString = recieve();
                    }catch(Exception ex) {}
                    if(recievingString != null && recievingString != "")
                        sendRecievedMessageOutside(recievingString);
                }
            }
        } );
        recievingRoutineThread.start();
    }
    private void sendRecievedMessageOutside(String message){
        messageConsumer.accept( message );
    }
}