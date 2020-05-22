synchronized(syncObject) {
    try {
        // Calling wait() will block this thread until another thread
        // calls notify() on the object.
        syncObject.wait();
    } catch (InterruptedException e) {
        // Happens if someone interrupts your thread.
    }
}