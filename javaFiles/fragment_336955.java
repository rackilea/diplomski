public void connect() {
    try {
        // this acquires a single permit for a shared semaphore,
        // so no more than 10 threads (the result of new Semaphore(10, true)) 
        // will enter the critical section below simultaneously
        sem.acquire();
    } catch (InterruptedException e1) {
        e1.printStackTrace();
    }

    try {
        // the critical section, at this point there will be 10 threads at max
        // this is the purpose of the semaphore
        doConnect();
    } finally {
        // returns the permit acquired, so that a one more thread may 
        // enter the critical section
        sem.release();
    }
}