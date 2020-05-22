static final AtomicInteger atomicInteger = new AtomicInteger(initialValue);
...
if (atomicInteger.get() <= 0) {
    return "imposibble. value=0";
}
int result = atomicInteger.decrementAndGet();
if (result < 0) {
    atomicInteger.incrementAndGet(); // Revert the effect of decrementing
    return "imposibble. value=0";
} else {
    return "new value=" + result;
}