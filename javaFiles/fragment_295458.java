class IAmRunnable implements Runnable {
     final NotRunnable nr;

    IAmRunnable( final NotRunnable nr) {
        this.nr = nr;
    }

    public void run() {
        synchronized (nr) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleeping Interrupted :( ");
            }
            nr.notify();                  // Line 2
        }
    }
}