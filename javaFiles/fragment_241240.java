static AtomicInteger c = new AtomicInteger();

public void knownNonThreadSafeMethod(final File file) throws IOException {
    int t = c.incrementAndGet();
    doSomething();   
    Thread.yield(); //try to force race conditions, remove in prod
    assert t == c.intValue();
}