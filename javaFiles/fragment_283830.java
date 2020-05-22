public synchronized void foo() {
    // this code uses the same lock...
}

public void bar() {
    synchronized (this) {
        // ...as this code
    }
}