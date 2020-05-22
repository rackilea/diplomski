new Thread(() -> {
    ServerSocket serverSocket = null;
    try {
        serverSocket = new ServerSocket(4558);
        Socket accept = serverSocket.accept();
    } catch (IOException e) {
        e.printStackTrace();
    }
}).start(); // was run();