private Socket socket;
private SSLServerSocket ssocket; 
private int port=6666;

while(true) {
    // Here I have code needed to create a ServerSocket
    try {
        connectToServerSocket();
    }  catch (IOException) {
        // log the exception
        continue;
    }


    while (listen) {
        // wait for client to connect
        try{
            socket = ssocket.accept();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }      
    }
}