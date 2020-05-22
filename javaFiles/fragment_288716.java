class ServerTask extends Task<Void> {
    ExecutorService executorService;
    final int PORT = 12345;

    private ServerSocket serverSocket ;

    @Override
    protected Void call() throws Exception {
        executorService = Executors.newFixedThreadPool(8);

        try (serverSocket = new ServerSocket(PORT)) {
            while (true)
            {
                executorService.execute(
                        new Client(serverSocket.accept()));
            }
        }
        catch (IOException e) {
            if (isCancelled()) {
                System.out.println("Cancelled");
            } else {
                System.out.print(e.getMessage());
            }
        }

        return null;
    }

    @Override
    protected void cancelled() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }
}