private Thread thread;    

public void start() {
    if (thread != null) return;
    thread = new Thread(new ListenerRunnable());
    thread.start();
}

public void stop() {
    if (thread == null) return;
    thread.interrupt();
    thread = null;
}

private static class ListenerRunnable implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {

                // !!! Here goes your code to listen !!!

            } catch (final InterruptedException e) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        }
    }
}