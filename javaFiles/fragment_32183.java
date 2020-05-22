Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    public void run() {
        System.out.println("JVM shutting down, closing Unirest");
        Unirest.shutdown();
    }
}));