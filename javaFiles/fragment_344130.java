public class LockSet {
    public Lock lock;
    public Condition condition;

    public LockSet() {
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }
}