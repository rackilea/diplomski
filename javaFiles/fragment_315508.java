public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        try {
            doSomeWork();
            Thread.sleep();
        } catch (Exception e) {
        }
    }
}