while (continueAccpetingConnections) {

    Socket socket = server.accept();
    process(socket);

}