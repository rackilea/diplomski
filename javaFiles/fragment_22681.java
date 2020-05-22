import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.concurrent.GuardedBy;

public class RoundRobin<P, E> {
    private final Lock lock = new ReentrantLock();
    private final Condition added = lock.newCondition();

    @GuardedBy("lock") private final Map<P, Queue<E>> queues = new LinkedHashMap<>();

    public boolean add(P producer, E item) {
        lock.lock();
        try {
            if (!queues.containsKey(producer)) {
                queues.put(producer, new PriorityBlockingQueue<>());
            }

            added.signalAll();
            return queues.get(producer).add(item);
        } finally {
            lock.unlock();
        }
    }

    public Iterator<E> roundRobinIterator() {
        return new Iterator<E>() {
            private Iterator<? extends Queue<E>> i = null;
            private boolean singlePass = true;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public E next() {
                lock.lock();
                try {
                    while (true) {
                        if (i == null || !i.hasNext()) {
                            i = queues.values().iterator();
                            singlePass = true;
                        }

                        while (i.hasNext()) {
                            Queue<E> q = i.next();
                            if (!q.isEmpty()) {
                                if (singlePass) {
                                    // copy the iterator to prevent
                                    // ConcurrentModificationExceptions
                                    singlePass = false;
                                    i = copy(i);
                                }
                                return q.poll();
                            }
                        }

                        if (singlePass) {
                            // If singlePass is true then we just checked every
                            // queue and they were all empty.
                            // Wait for another element to be added.
                            added.await();
                        }
                    }
                } catch (InterruptedException e) {
                    throw new NoSuchElementException(e.getMessage());
                } finally {
                    lock.unlock();
                }
            }

            private <T> Iterator<? extends T> copy(Iterator<? extends T> i) {
                List<T> copy = new ArrayList<>();
                while (i.hasNext()) {
                    copy.add(i.next());
                }
                return copy.iterator();
            }
        };
    }
}