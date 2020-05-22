public abstract class EventHandlingThread<Event> extends Thread {
    private ArrayBlockingQueue<Event> queue = new ArrayBlockingQueue<Event>();
    private boolean done;

    protected abstract void respondToEvent(Event event);
    public final void postEvent(Event event) throws InterruptedException {
        queue.put(event);
    }
    protected final void done() {
        done = true;
    }
    public final void run() {
        try {
            while (!done) {
                respondToEvent(queue.take());
            }
        } catch (InterruptedException e) {
            // Maybe log this, maybe not...
        } catch (RuntimeException e) {
            // Probably should log this!
        }
    }
}