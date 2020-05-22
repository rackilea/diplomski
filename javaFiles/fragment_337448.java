public void startListen() throws IOException {
    while (true) {
        Socket clientSocket = serverSocket.accept();
        threadPool.submit(new XClientHandler(clientSocket,eventProducer));
    }
}