public static void startServer() {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    ServerSocket server = new ServerSocket(9090);
    executorService.execute(() -> {
       Socket client1 = server.accept();
       Socket client2 = server.accept();
       executorService.execute(new ServerConnection(client1, client2));
    });
}