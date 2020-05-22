public static void main(String args[]) throws IOException {
        ServerSocket server;
        try{
            server = new ServerSocket(5559);
            System.out.println("Listening for connection on port 5559 ....");

            while (true) {
                Socket clientSocket = server.accept();
                new Thread(new WorkerRunnable(clientSocket)).start();
            }

        }catch (IOException e) {
            System.out.println("Could not listen on port: 4001");
        }
    }