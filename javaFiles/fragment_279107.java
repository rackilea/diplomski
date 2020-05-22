final Object lock1 = new Object();
final Object lock2 = new Object();

public void method1() {
    synchronized (lock1) {
        // Call Thread.sleep(1000) here to simulate the thread losing its time slice.
        synchronized(lock2) {
            doSomethingThatRequiresBothLocks
        }
    }
}

public void method2() {
    synchronized (lock2) {
        // Do the same here 'cause you can't know which thread will get to run first.
        synchronized(lock1) {
            doSomethingElseThatRequiresBothLocks()
        }
    }
}