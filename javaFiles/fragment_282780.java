Lock lock = new ReentrantLock(true);

public void methodA() {
    lock.lock();
    try {
        // Write something to a file.
    } finally {
        lock.unlock();
    }
}

public void methodB() {
    lock.lock();
    try {
        // Write something to a file.
    } finally {
        lock.unlock();
    }
}