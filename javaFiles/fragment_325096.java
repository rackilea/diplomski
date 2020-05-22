// My lock class.
public static class Padlock<E extends Enum<E>> {

    // Using Markable because I think I'm going to need it.
    public final AtomicReference<E> value;
    // Perhaps use a set to maintain all waiters.
    Set<Thread> waiters = ConcurrentHashMap.newKeySet();

    public Padlock(E initialValue) {
        this.value = new AtomicReference<>(initialValue);
    }

    /**
     * Waits for the locks value to become the specified key value.
     *
     * @param waitFor - The desired key.
     */
    public void compareAndWait(E waitFor) {
        log("Wait for " + waitFor);
        // Spin on the value.
        while (value.get() != waitFor) {
            log("Park waiting for " + waitFor);
            // Remember me as waiting.
            waiters.add(Thread.currentThread());
            // TODO: What do we do here??
            LockSupport.park();
            log("Awoke " + waitFor);
        }
    }

    /**
     * Sets the locks value to the key value.
     *
     * If this resulted in a change - notify all changers.
     *
     * @param shouldBe - What it should be now.
     * @param makeIt - The new value to set.
     */
    public void setAndNotify(E shouldBe, E makeIt) {
        log("Set " + shouldBe + "->" + makeIt);
        if (value.compareAndSet(shouldBe, makeIt)) {
            log("Notify " + shouldBe + "->" + makeIt);
            // It changed! Notify the waiters.
            for (Thread t : waiters) {
                // Perhaps
                log("Unpark " + t.getName());
                LockSupport.unpark(t);
            }
        }
    }
}

enum State {

    Off, On;
}

private static final long TESTTIME = 30000;
private static final long TICK = 100;

private static final void log(String s) {
    System.out.println(Thread.currentThread().getName() + ": " + s);

}

static class MutexTester implements Runnable {

    final Padlock<State> lock;

    public MutexTester(Padlock<State> lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.getClass().getSimpleName());
        long wait = System.currentTimeMillis() + TESTTIME;
        do {
            // Wait for an On!
            lock.compareAndWait(Test.State.On);
            try {
                log("Got it!");
                try {
                    Thread.sleep(TICK);
                } catch (InterruptedException ex) {
                    log("Interrupted!");
                }
            } finally {
                // Release
                lock.setAndNotify(Test.State.On, Test.State.Off);
            }
        } while (System.currentTimeMillis() < wait);
        log("Done");
    }
}

static class RandomSwitcher implements Runnable {

    final Padlock<State> lock;
    final Random random = new Random();

    public RandomSwitcher(Padlock<State> lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.getClass().getSimpleName());
        long wait = System.currentTimeMillis() + TESTTIME;
        do {
            // On!
            lock.setAndNotify(Test.State.Off, Test.State.On);
            log("On!");
            pause();
            lock.setAndNotify(Test.State.On, Test.State.Off);
            log("Off!");
            pause();
        } while (System.currentTimeMillis() < wait);
        log("Done");
    }

    private void pause() {
        try {
            // Random wait.
            Thread.sleep(TICK * random.nextInt(10));
        } catch (InterruptedException ex) {
            System.out.println("Interrupted! " + Thread.currentThread().getName());
        }
    }
}

public void test() throws InterruptedException {
    final Padlock<State> lock = new Padlock<>(State.Off);
    Thread t1 = new Thread(new MutexTester(lock));
    t1.start();
    Thread t2 = new Thread(new RandomSwitcher(lock));
    t2.start();
    t1.join();
    t2.join();
}