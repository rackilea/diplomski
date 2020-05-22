public void waitForThread() {
    synchronized (consumerThread) {
        while (consumer.running.get()) {
            try {
                consumerThread.wait(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    if (!consumer.running.get()) {
        consumerThread.interrupt();
    }

    System.out.println("Thread complete at " + new Date());
}