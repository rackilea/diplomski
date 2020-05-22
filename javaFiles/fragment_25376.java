file.read()
    .thenCompose(bytes -> socket.write(bytes))
    .thenAccept(count -> log.write("Wrote {} bytes to socket.", count)
    .exceptionally(exception -> {
        log.error("Input/output error.", exception);
        return null;
    });