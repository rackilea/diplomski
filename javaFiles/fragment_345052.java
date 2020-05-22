private StorageConnection allocateConnection() {
    boolean interrupted = false;
    boolean allocated = false;
    while( !allocated ){
        try {
            semaphore.acquire();
            allocated = true;
        } catch (InterruptedException e) {
            interrupted = true;
        }
    }

    StorageConnection connection = connectionQueue.poll();
    // OTHER LOGIC

    if (interrupted) {
        Thread.currentThread().interrupt();
    }

    return connection;
}