Thread targetThread = new Thread() {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Target thread completed normally");
        } catch(final InterruptedException ie) {
            System.out.println("Target thread was interrupted");
        }
    }
};

targetThread.start();
targetThread.interrupt();