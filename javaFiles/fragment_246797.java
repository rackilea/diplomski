public interface Box {
    public void open();
    public void close();
}
public interface LockableBox extends Box {
    public void lock();
    public void unlock();
}
public interface MutableBox extends Box {
    public void putItem(int item);
    public void removeItem(int item);
}