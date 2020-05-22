private Striped<Lock> STRIPPED_LOCK = Striped.lock(64);

public static void doActualWork(int id) throws InterruptedException {
    try {
        STRIPPED_LOCK.get(id).lock();
        ...
    } finally {
        STRIPPED_LOCK.get(id).unlock();
    }
}