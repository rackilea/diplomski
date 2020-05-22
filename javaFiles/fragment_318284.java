public synchronized void methodA() {
    // ... Some code
    // releases the lock, waits 1000 ms or until notify()ed, & regains the lock.
    wait(1000); 
    // .. some code.
    methodB(); // doesn't do anything to the lock
    // ... Some more code
}