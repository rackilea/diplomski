server = new ServerSocket(port);

while (continueAccpetingConnections) {

    Socket socket = server.accept();
    Thread thread = new Thread(new SocketHandler(socket));
    thread.start();

}