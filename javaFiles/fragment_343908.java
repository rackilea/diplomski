public final class MyHttpSessionListener implements HttpSessionListener {

    private static final AtomicInteger counterA = 
            new AtomicInteger();

    private static final AtomicInteger counterB =
            new AtomicInteger();

    public void incA() {
        counterA.incrementAndGet();
    }

    ...
}