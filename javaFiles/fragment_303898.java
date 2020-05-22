public synchronized void deadlock() throws InterruptedException {
    Thread th = new Thread() {
        public void run() {
            deadlock();
        }
    }.start();

    th.join();
}