public boolean acquire(long timeout, TimeUnit timeUnit) {
    // actual implementation
}
static final Duration MAX_WAIT = Duration.ofNanos(Long.MAX_VALUE);
public boolean acquire(Duration timeout) {
    return acquire(
        timeout.compareTo(MAX_WAIT)>=0? Long.MAX_VALUE: timeout.toNanos(),
        TimeUnit.NANOSECONDS);
}