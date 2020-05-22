private class SendMessage implements Runnable {
    private String mMsg;

    public SendMessage(String msg) {
        mMsg = msg;
    }

    public void run() {
        try {

            client = new Socket("localhost", 7575);  //connect to server
            printwriter = new PrintWriter(client.getOutputStream(),true);
            printwriter.write(messsage);  //write the message to output stream

            printwriter.flush();
            printwriter.close();
            client.close();   //closing the connection

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}