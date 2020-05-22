class Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocket = ServerSocketChannel.open();
            serverSocket.configureBlocking(false);
            serverSocket.bind(port);

            while(running) {
                SocketChannel channel = serverSocket.accept();

                //...
            }
        }
    }
}