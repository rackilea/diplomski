public class Server {
    private static final int SERVER_READY = 1;
    private static final int SERVER_BUSY = 0;

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        int port = Integer.valueOf(args[0]);
        System.out.println(String.format("Starting server on port %s", port));
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is ready");

        Thread clientThread = null;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            OutputStream os = clientSocket.getOutputStream();
            if (clientThread != null && clientThread.isAlive()) {
                os.write(SERVER_BUSY);
                continue;
            }
            os.write(SERVER_READY);
            System.out.println(String.format("Client connected: %s", clientSocket.getInetAddress()));
            clientThread = new Thread(new ClientWorker(clientSocket));
            clientThread.start();
        }
    }

    public static class ClientWorker implements Runnable {
        private final Socket clientSocket;

        ClientWorker(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                handleClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private void handleClient() throws IOException, ClassNotFoundException {
            try {
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
                while (true) {
                    System.out.println("Waiting for command..");
                    String cmd = (String) in.readObject();
                    System.out.println(String.format("Command received:\n %s", cmd));
                    if (cmd.equals("exit"))
                        break;
                    Command command = new Gson().fromJson(cmd, Command.class);
                    CommandResult commandResult = command.run();
                    String jsonCommandResult = new Gson().toJson(commandResult);
                    System.out.println(String.format("Sending response:\n %s", jsonCommandResult));
                    out.writeObject(jsonCommandResult);
                    out.flush();
                }
                //in case the client connection has closed, we want to end the while loop and accept a new client
            } catch (EOFException | SocketException e) {
            }
            System.out.println("Connection has been closed");
            clientSocket.close();
            System.out.println("Server is ready");
        }
    }
}