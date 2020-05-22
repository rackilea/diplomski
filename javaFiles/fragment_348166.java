// initialize our shared counter to 10
final AtomicInteger threadCounter = new AtomicInteger(10);
// ...
// to add:
threadCounter.addAndGet(5);
// to subtract:
threadCounter.addAndGet(-7);
// ...
// to get the value after the joins
threadCounter.get();