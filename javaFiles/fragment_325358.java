private ExecutorService executorService = Executors.newFixedThreadPool(10);

private void acceptConnections() {
    listening = true;
    while (listening) {
        try {
            final Socket connection = serverSocket.accept();
            System.err.println("SERVER - connection from: " + connection.getInetAddress());
            executorService.execute(new ConnectionHandler(connection));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}