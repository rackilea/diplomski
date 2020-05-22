public void stop() {
    thread.interrupt();
}

public void run() {
    while (!Thread.currentThread.isInterrupted()) {
        ...
    }
}