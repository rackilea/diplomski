private final AtomicBoolean isClosed = new AtomicBoolean(false);

...

public void close() {
    if (this.isClosed.compareAndSet(false, true) {
        ....
    }
}