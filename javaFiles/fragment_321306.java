private final Socket accept(final ServerSocket serverSocket) {
    try {
        return serverSocket.accept();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}