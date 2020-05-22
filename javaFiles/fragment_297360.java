public class SharedMemory<K> {

private final List<K> memoryList;
private static final ReentrantLock lock = new ReentrantLock();

public SharedMemory() {
    memoryList = new ArrayList<>();
}

public void storeItem(K item) {
    memoryList.add(item);
}

public K getItem(int pos){
    lock.lock();
    try{
        return memoryList.get(pos);
    } finally {
        lock.unlock();
    }
}
}