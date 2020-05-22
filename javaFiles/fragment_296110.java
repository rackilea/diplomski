Thread t = new Thread() {
    @Override
    public void run() {
        while (shouldLoop() && !isInterrupted()) {
            . . .
        }
    }
}();

// somewhere else:
t.interrupt(); // will exit thread on next loop iteration