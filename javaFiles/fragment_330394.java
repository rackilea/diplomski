Object monitor = new Object();

// thread 1    
synchronized(monitor) {
    monitor.wait();
}

// thread 2
synchronized(monitor) {
    monitor.notify();
}