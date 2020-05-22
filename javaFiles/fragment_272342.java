public class MyRunnableClass implements Runnable {

    static AtomicInteger stash = new AtomicInteger(1000);
    int y = 0;

    @Override
    public void run() {
        try {
            while (getFromStash()) {
                // Sleep a little 'cause I'm on a single-core machine.
                Thread.sleep(0);
                // Count how much of the stash I got.
                y += 1;
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted!");
        }
    }

    public boolean getFromStash() {
        // It must be > 0
        int was = stash.get();
        while (was > 0) {
            // Step down one.
            if (stash.compareAndSet(was, was - 1)) {
                // We stepped it down.
                return true;
            }
            // Get again - we crossed with another thred.
            was = stash.get();
        }
        // Must be 0.
        return false;
    }
}