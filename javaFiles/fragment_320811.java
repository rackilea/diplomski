public class Batcher<T> implements Consumer<T> {

    private final int batchSize;
    private final Executor executor;
    private final Consumer<List<T>> actualAction;
    private final Phaser phaser = new Phaser(1);
    private ArrayList<T> batch;
    private int processed;

    public Batcher(int batchSize, Executor executor, Consumer<List<T>> c) {
        this.batchSize = batchSize;
        this.executor = executor;
        this.actualAction = c;
        this.batch = new ArrayList<>(batchSize);
    }

    public void accept(T item) {
        processed++;
        if(batch.size()==batchSize) flush();
        batch.add(item);
    }

    public int getProcessedCount() {
        return processed;
    }

    public void flush() {
        List<T> current = batch;
        if (batch.isEmpty())
            return;
        batch = new ArrayList<>(batchSize);
        phaser.register();
        executor.execute(() -> {
            try {
                actualAction.accept(current);
            }
            finally {
                phaser.arrive();
            }
        });
    }

    public void awaitDone() {
        flush();
        phaser.arriveAndAwaitAdvance();
    }

    public void awaitDone(long duration, TimeUnit unit) throws TimeoutException {
        flush();
        try {
            phaser.awaitAdvanceInterruptibly(phaser.arrive(), duration, unit);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}