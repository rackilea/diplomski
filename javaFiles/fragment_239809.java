new Thread(new Runnable() {
    @Override
    public void run() {
        while(notShutdown()) {
            waitingForTask(); // may get blocked
            runTask(); // execute Runnable user submits
        }
    }
});