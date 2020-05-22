final AtomicInteger occupied = new AtomicInteger();
...
int prev;
int numResources = myTask.getResources();
do {
    prev = occupied.get();
    if (numResources + prev > limit) return false;
} while (!occupied.compareAndSet(prev, prev + numResources));