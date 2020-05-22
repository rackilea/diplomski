public ServerThread(ServerSocket ss, Configuration newConfig) {
    super();
    serverSocket = ss;
    config = newConfig;
    start();
}