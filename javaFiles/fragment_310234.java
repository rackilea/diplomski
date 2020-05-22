private static final class MyBarrierWithPhaser {

    private final Phaser phaser = new Phaser(1);
    private int lastObservedPhase; // Phaser has initial phase 0

    void await() throws InterruptedException {
        // only works for 1 producer 1 worker; lastObservedPhase is kind of thread-local
        lastObservedPhase = phaser.awaitAdvanceInterruptibly(lastObservedPhase);
    }

    void signal() {
        phaser.arrive();
    }
}