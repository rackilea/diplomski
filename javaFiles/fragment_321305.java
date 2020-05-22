private final Socket accept(final ServerSocket serverSocket) {
    try (Socket clientSocket = serverSocket.accept()) {
        return clientSocket;
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}