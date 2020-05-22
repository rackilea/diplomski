import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockWrapper {

private final ReadWriteLock readWriteLock;
private final Map<Integer, Object> map;
private final EventSender sender;

public LockWrapper(EventSender eventSender) {
    map = new HashMap<>();
    readWriteLock = new ReentrantReadWriteLock();
    sender = eventSender;
}

public void add(Object o) {
    readWriteLock.writeLock().lock();
    try {
       if (map.isEmpty()) {
          sender.send("First add");
       }
       map.put(o.hashCode(), o); // for example using hashcode for key
    }
    finally {
       readWriteLock.writeLock().unlock();
    }
}

public void remove(Object o) {
    readWriteLock.writeLock().lock();
    try {
      map.remove(o.hashCode());

      if (map.isEmpty()) {
         sender.send("remove last");
      }
    }
    finally {
      readWriteLock.writeLock().unlock();
    }  
}

public Object read(int key) {
    readWriteLock.readLock().lock();
    try {
      Object object = map.get(key);
    } 
    finally {
      readWriteLock.readLock().unlock();
    }  
    return object;
}}