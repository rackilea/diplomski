ReentrantLock lock = new ReentrantLock();
Condition condition = lock.newCondition();
// ... (share the object across threads)
if (condition.await(10, TimeUnit.SECONDS)) {
    // signaled (equivalent of notify)
} else {
    // time elapsed
}
// ... (in other thread)
condition.signal();