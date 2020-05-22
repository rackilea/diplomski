boolean ready = false;

// thread 1
synchronized(lock) {
    ready = true;
    lock.notifyAll();
}


// thread 2
synchronized(lock) {
    while(!ready) 
        lock.wait();
}