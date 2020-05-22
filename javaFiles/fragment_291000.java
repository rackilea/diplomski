public synchronized void methodA() {
    methodB();
}

public void methodB() {
    // Block B code
    // Nothing prevents an unsynchronized method from calling this method
    //   at same time as methodA() holds  lock on `this` object
}