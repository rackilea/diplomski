private static volatile ServerSocket serverSocket;

public static void main(String[] args) throws InterruptedException, IOException {
    Thread serverThread = new Thread(new ServerThread());
    serverThread.start();
    Thread.sleep(1000); // wait a  bit, then close
    serverSocket.close();
}

static class ServerThread implements Runnable {

    private BufferedReader input;

    public void run() {
        try {
            serverSocket = new ServerSocket(25);
            while (true) {
                Socket socket = serverSocket.accept();
                // client request handling logic
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}