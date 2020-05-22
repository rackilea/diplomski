public static class BlockingQueueWithPause<E> extends LinkedBlockingQueue<E> {

    private static final long serialVersionUID = 184661285402L;

    private final Phaser phaser = new Phaser(1);
    private volatile int phase = phaser.getPhase();

    public BlockingQueueWithPause() {
        // base case, all phase 0 await's will succeed through.
        phaser.arrive();
    }

    public void pause() {
        phase = phaser.getPhase();
    }

    public void unpause() throws InterruptedException {
        phaser.arrive();
    }

    @Override
    public E take() throws InterruptedException {
        phaser.awaitAdvance(phase);

        E result = super.take();

        return result;
    }
}