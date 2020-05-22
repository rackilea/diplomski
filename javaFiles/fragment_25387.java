public boolean tryAcquire(long timeout, TimeUnit unit, Long userId)
    throws InterruptedException {
    AtomicLong connCount = userConnetctionMap.contains(userId) ? userConnetctionMap.get(userId) :  userConnetctionMap.put(userId, new AtomicLong(0));
    if (connCount.get() < MAX_USER_CONN_COUNT) {
        boolean locked = super.tryAcquire(timeout, unit);
        if (locked) {
            userConnetctionMap.get(userId).incrementAndGet();
            return true;
        }
    }
    return false;
}