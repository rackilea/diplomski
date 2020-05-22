public class Item {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    String name;
    ...
}