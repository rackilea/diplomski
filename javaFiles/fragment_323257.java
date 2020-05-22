protected int tryAcquireShared(int acquires) {
        for (;;) {
            if (getFirstQueuedThread() != Thread.currentThread() &&
                hasQueuedThreads())
                return -1;
         ....