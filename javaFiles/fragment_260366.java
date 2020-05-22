public class ChatServerThread implements Runnable {

    .......

    public void run() {
        try {
            handleClient();
        } catch( EOFException eof ) {
            System.out.println("Client closed the connection.");
        } catch( IOException ioe ) {
            ioe.printStacktrace();
        }
    }

    public void handleClient() throws IOException {
       boolean done = false;
       try {
          while(!done) {  
             String nextCommand = streamIn.readUTF();
             if( nextCommand.equals(".bye") ) {
                done = true;
             } else {
                System.out.println( nextCommand );
             }
          }
       } finally {
          streamIn.close();
          streamOut.close();
          socket.close();
       }
    }
}