public void run() {
    while (!Thread.currentThread().isInterrupted()) {
        try {
            outputQueue.put(inputQueue.take());
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}