class Parent {
    static WebSocket socket;
    // this is where the socket runs
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        createSocket();
    }

    private static void createSocket() {
        Parent.socket = new WebSocket(() -> {
            EXECUTOR.submit(Parent::createSocket);
        });
    }
}