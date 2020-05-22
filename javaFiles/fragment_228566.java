class Second implements Runnable {
    Thread other;
    Second(Thread t) {other = t;}
    public void run() {
        other.run();
    }
}