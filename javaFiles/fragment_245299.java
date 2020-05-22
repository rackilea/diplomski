Object lock1 = new Object();
Object lock2 = new Object();

public void method1() {
    synchronized(lock1) {
        ...
    }
}

public void method2() {
    synchronized(lock2) {
        ...
    }
}