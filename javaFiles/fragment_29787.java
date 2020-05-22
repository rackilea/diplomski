private BlockingQueue<Update> updateQueue = new LinkedBlockingQueue<Update>();
...
// called by the updater thread(s)
public void updateData(Update update) {
    updateQueue.put(update);
}
// called by the collector
public void collect() {
    while (!Thread.currentThread().isInterrupted()) {
        Update update = updateQueue.take();
        updateValues(update);
        if (updateQueue.isEmpty()) {
           analyzeData();
        }
    }
}