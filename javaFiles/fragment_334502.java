public static boolean isReadyForRead(SocketChannel socket) throws IOException {
    return isReady(socket, SelectionKey.OP_READ);
}

public static boolean isReadyForWrite(SocketChannel socket) throws IOException {
    return isReady(socket, SelectionKey.OP_WRITE);
}

public static boolean isReady(SocketChannel socket, int op) throws IOException {
    // Setup
    if (socket.isBlocking()) 
        throw new IllegalArgumentException("Socket must be in non-blocking mode");

    Selector selector = SelectorProvider.provider().openSelector();
    socket.register(selector, op);

    // Real work
    if (selector.selectNow() == 0)
        return false;
    // Just in case selector has other keys
    return selector.selectedKeys().contains(socket.keyFor(selector));
}