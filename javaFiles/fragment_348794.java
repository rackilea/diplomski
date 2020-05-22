int bufferSize = 8192;
ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(ibmPort));
while (true) {
    Socket connectionSocket = welcomeSocket.accept();
    ByteBuffer bf = ByteBuffer.allocate(bufferSize);
    BufferedInputStream inFromClient = new BufferedInputStream(connectionSocket.getInputStream());
    while (true) {
        int b = inFromClient.read();
        if (b == -1) {
            break;
        }
        bf.put( (byte) b);
    }
    connectionSocket.close();
}