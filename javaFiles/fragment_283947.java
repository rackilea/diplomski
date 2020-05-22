class SimpleServer extends DefaultGui {
    private ServerSocket serverSocket;

    public SimpleServer(int port, String name, boolean myTurn) throws IOException {
        super(port, name, myTurn);
        serverSocket = new ServerSocket(port);
        new Thread(() -> {
            try {
                // accept() blocks the current thread, so must be called on a background thread
                socket = serverSocket.accept();
                inputScanner = new Scanner(socket.getInputStream());
                out = new PrintStream(socket.getOutputStream(), true);
                new MyWorker(inputScanner, this).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }    
}