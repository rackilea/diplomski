public void shutdown() {
    for (Thread t : threads) {
        try {
            t.join();
        } catch (InterruptedException e) { /* NOP */ }
    }
}