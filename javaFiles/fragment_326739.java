someMethod() {

    // Your array of sockets
    Socket[] clientSockets;

    // Create a new Thread to handle each socket and start them
    for (int i = 0 ; i < clientSockets.length ; ++i) {
        Thread t = new ListenToClientThread(clientSockets[i]);
        t.start();
    }
}

// When you call start() on a Thread it calls run()
class ListenToClientThread extends Thread {
    private Socket socket;

    ListenToClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        PrintWriter out =
            new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        String response;
        while((response = in.readLine()) != null) {//do something}
    }
}