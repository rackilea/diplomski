static final AtomicInteger counter = new AtomicInteger(1);
...
synchronized (counter) {
    // looping like this is always recommended
    while (counter.get() != value) {
       counter.wait();
    }
    System.out.println(...);
    counter.incrementAndGet();
    counter.notifyAll();
}