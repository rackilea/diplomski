// Somewhat pseudo-code...
Server server = new Server();
server.onStartedListening(new Runnable() {
    @Override public void run() {
        executor.execute(new ClientConnection());
    }
});
executor.execute(server);