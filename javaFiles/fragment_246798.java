public class RedBox implements LockableBox {
    public void open() {}
    public void close() {}
    public void lock() {}
    public void unlock() {}
}

public class BlueBox implements MutableBox {
    public void open() {}
    public void close() {}
    public void putItem(int item) {}
    public void removeItem(int item) {}
}