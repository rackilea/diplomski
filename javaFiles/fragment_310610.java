public void mymethod() {
//...
Lock lock = getLock(mySession);
if (lock == null) {
    synchronized (myService.class) {
        lock = getLock(mySession);
        if (lock == null) {
            lock = new ReentrantLock();
            setLock(mySession, lock);
        }
    }
}
//...
}