final AtomicInteger A = new AtomicInteger(-1), B = new AtomicInteger(-1);
int cachedB = -1;

int readersCount;

int waitForB() throws InterruptedException { // Can be called by many threads.
    synchronized (B) {
        while (cachedB != -1) B.wait();

        readersCount ++;

        while (A.get() <= B.get()) { B.wait(); }

        if (cachedB == -1) {
            cachedB = B.get();
            A.set(B.get());

            readersCount--;
            if (readersCount == 0) { cachedB = -1; B.notifyAll(); }

            return B.get();
        } else {
            int ret = cachedB;

            readersCount--;
            if (readersCount == 0) { cachedB = -1; B.notifyAll(); }

            return ret;
        }
    }
}

void updateB(int newB) { // Called by one thread.
    synchronized (B) {
        B.set(newB);
        B.notifyAll(); // All blocked threads must receive new B.
    }
}