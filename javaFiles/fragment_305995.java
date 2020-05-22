public synchronized void stop() {
    try {
        thread.join();
        running = false;
    } catch(Exception e) {
        e.printStackTrace();
    }
}