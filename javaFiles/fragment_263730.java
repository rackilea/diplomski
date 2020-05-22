Object sync = new Object();  // Can use an existing object if there's an appropriate one

// On submit to queue
synchronized ( sync ) {
    queue.add(...);  // Must be inside to avoid a race condition
    sync.notifyAll();
}

// On check for work in queue
synchronized ( sync ) {
    item = null;
    while ( item == null ) {
        // Need to check all of the queues - if there will be a large number, this will be slow,
        // and slow critical sections (synchronized blocks) are very bad for performance
        item = getNextQueueItem();
        if ( item == null ) {
            sync.wait();
        }
    }
}