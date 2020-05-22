public ServerClient(int port) {
    Server server = new Server(port);
    server.start();
    Client client = new Client(port);
    client.start();
}