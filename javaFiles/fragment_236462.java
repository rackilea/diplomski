public void run() {
    // create the server socket once
    ssChannel = ServerSocketChannel.open();
    ssChannel.configureBlocking(false);
    ssChannel.socket().bind(new InetSocketAddress(2345));

    while (true) {
        // accept new connections on the socket
        try {
            SocketChannel accept = ssChannel.accept();
            System.out.println("new client: " + accept.getRemoteAddress());
        } catch (Exception e) {
            System.out.println("exception: " + e.getMessage());
        }
    }
}