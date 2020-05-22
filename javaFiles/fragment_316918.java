@Override
public SomeRespose makeSomeAction() {
    ...
    // Instance of ReentrantLock
    lock.lock();
    try {
        anotherService.getToken());
    }
    finally {
        lock.unlock();
    }
    ....
}