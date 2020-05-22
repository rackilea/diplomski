Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignored) {
            //
        }
    }
});