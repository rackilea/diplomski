while(true)
{
    // listen for a connection request
    Socket socket = serverSocket.accept();

    Platform.runLater(() -> {
        InetAddress inetAddress = socket.getInetAddress();
        textArea.appendText("Connected to " + inetAddress.getHostAddress() + " at " + new Date() + "\n");
    });


    // create and start a new thread for every connection
    new Thread(new HandleAClient(socket, textArea)).start();

}