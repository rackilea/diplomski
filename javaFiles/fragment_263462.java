final Process process = startNewProcess();
Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    @Override
    public void run() {
        process.waitFor();
    }
}));