/**
 * Atomically increments by one the current value.
 *
 * @return the updated value
 */
public final long incrementAndGet() {
    for (;;) {
        long current = get();
        long next = current + 1;
        if (compareAndSet(current, next))
            return next;
    }
}