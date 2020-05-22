static final int executors = Runtime.getRuntime().availableProcessors() * 2;
ExecutorService[] executors = new ExecutorService[executors];
// fill with single threaded executors.

public Future submit(Object actorId, Runnable r) {
    int h = (actorId.hashCode() & 0x7FFF_FFFF) % executors;
    return executors[h].submit(r);
}