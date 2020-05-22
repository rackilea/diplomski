final Thread mainThread = Thread.currentThread();
Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {

        //close
        mainThread.join();
    }
});