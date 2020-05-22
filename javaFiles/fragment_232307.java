class Whatever implements Runnable {
    private volatile String string;

    @Override
    public void run() {
        string = "whatever";
    }

    public String getString() {
        return string;
    }

    public void main(String[] args) throws InterruptedException {
        Whatever whatever = new Whatever();
        Thread thread = new Thread(whatever);
        thread.start();
        thread.join();
        String string = whatever.getString();
    }
}