class SimpleClient extends DefaultGui {

    public SimpleClient(int port, String name, boolean myTurn) throws IOException {
        super(port, name, myTurn);
        socket = new Socket("localhost", port);
        inputScanner = new Scanner(socket.getInputStream());
        out = new PrintStream(socket.getOutputStream());
        new MyWorker(inputScanner, this).execute();
    }    
}