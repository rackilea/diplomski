public final int getAndIncrement(int modulo) {
    for (;;) {
        int current = atomicInteger.get();
        int next = (current + 1) % modulo;
        if (atomicInteger.compareAndSet(current, next))
            return current;
    }
}