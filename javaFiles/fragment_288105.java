public static void main(String[] args) throws Exception
    // Creating Threadpool with the thread size given above
    ExecutorService executor = Executors.newFixedThreadPool(5);

    ServerSocket server = new ServerSocket(8080);
    while (true) {
        Socket socket = server.accept();
        handleAsync(executor, socket);
    }
}

private void handleAsync(ExecutorService executor, final Socket socket) {
    executor.execute(new Runnable() {
        public void run() {
            handle(socket);
        }
    };
}

private static void handle(Socket socket) {
    // TODO: communicate with client using socket
}