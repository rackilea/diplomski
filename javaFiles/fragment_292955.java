class threadFirst extends Thread {
    ...
    public void run() {
        synchronized (q) {
            //your loop here
        }
    }
    ...
}