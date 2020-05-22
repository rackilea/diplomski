static boolean socketIsAlive;

...
    BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    while (true)
        try (
            Socket clientSocket = new Socket(hostname, port);
            PrintWriter socketOut = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            socketIsAlive=true;
            new ConnectionChecker(clientSocket).start();
            String input;
            while (true) {
                if ((input=stdIn.readLine())!=null)
                    socketOut.println(input);
                if (!socketIsAlive) {
                    System.out.println("Got socket error");
                    break;
                }
            }
        } catch (IOException e) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {}
        }
    }
...

static public class ConnectionChecker extends Thread{
    Socket socket;

    public ConnectionChecker(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            if (socket.getInputStream().read()==-1)
                socketIsAlive=false;
        } catch (IOException e) {}
    }
}