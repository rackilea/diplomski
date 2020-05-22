public abstract class JavaFXWorker<T> implements Runnable {

    private final List<T> results = new LinkedList<>();
    private final Object lock = new Object();
    private boolean updateWaiting = false;

    protected void publish(T... values) {
        synchronized (lock) {
            for (T v : values) {
                results.add(v);
            }

            // don't trigger additional updates, if last update didn't fetch the results yet
            // this reduces the number of Runables posted on the application thread
            if (!updateWaiting) {
                updateWaiting = true;
                Platform.runLater(this::update);
            }
        }
    }

    private void update() {
        List<T> chunks;
        synchronized(lock) {
            // copy results to new list and clear results
            chunks = new ArrayList(results);
            results.clear();
            updateWaiting = false;
        }
        // run ui updates
        process(chunks);
    }

    protected abstract void process(List<T> chunks);

}