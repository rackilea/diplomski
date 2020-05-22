// You probably need to make this a (private final) field
Object lock = new Object();

// later
synchronized (lock) {
    for(int i = 0; i < n; i++) {
        Worker currThread = new Worker(someArgs);
        workerThreads.add(currThread);
        w.start();
    }
}

// later still
public void actionPerformed(ActionEvent arg0) {
    synchronized (lock) {
        // interruption code here
    }
}