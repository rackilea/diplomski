ServerSocket server = new ServerSocket(8080);

while (running) {
    Socket socket = server.accept();
    handleConnection(socket);
}