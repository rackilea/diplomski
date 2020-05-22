public E removeFirst() {
        E x = pollFirst();
        ..
    }
 public E pollFirst() {
        lock.lock(); //Common lock for while list
        try {
            return unlinkFirst();
        } finally {
            lock.unlock();
        }
    }