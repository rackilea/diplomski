BlockingDeque<Object> queue = new LinkedBlockingDeque<Object>(1);

public void postMessage(Object message) {
    // If previous message is still pending we replace it.
    queue.clear();
    queue.offer(message);
}

public Object getNextMessage() {
    while (true) {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            // Ignore interrupts
        }
    }
}