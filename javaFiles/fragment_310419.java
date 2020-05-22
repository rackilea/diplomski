/**
     * Worker thread interrupt condition object.
     */
    final AtomicBoolean interruptCond = new AtomicBoolean();

    /**
     * Sleeps for a given period or until the interruptCond is set
     */
    public boolean conditionalSleep(long ms) throws InterruptedException {
        long endTime = System.currentTimeMillis() + ms, toGo;
        while ((toGo = endTime - System.currentTimeMillis()) > 0) {
            synchronized (interruptCond) {
                interruptCond.wait(toGo);
                if (interruptCond.get())
                    break;
            }
        }
        return interruptCond.get();
    }

    /**
     * The worker thread loop.
     */
    public void run() {
        while (true) {
            if (conditionalSleep(timeToNextSubtitle)) {
                adjustSpeed();
                continue;
            }
            showNextSubtitle();
        }
    }

    /**
     * Interrupts the worker thread after changing timeToNextSubtitle.
     */
    public void notifyCond() {
        synchronized (interruptCond) {
            interruptCond.set(true);
            interruptCond.notifyAll();
        }
    }