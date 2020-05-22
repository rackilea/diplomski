private Object lock = new Object();
private Queue<Thread> threadQueue = new ArrayDeque<>();

// https://stackoverflow.com/questions/32353283/synchronization-threads-execute-two-critical-sections-in-same-order
public void executeCriticalSectionsInOrder() throws InterruptedException {
    // Critical Section #1
    synchronized (lock){
        // synchronized code #1

        // Add self to queue
        threadQueue.add(Thread.currentThread());
    }

    // {lot of code where synchronization not necessary}

    // Critical Section #2
    synchronized (lock) {
        //All the threads that executed block1 before this thread should have already executed this block.
        // Wait turn
        Thread t = threadQueue.element(); // Do not remove until it is self
        while (t != Thread.currentThread()) {
            lock.wait();
            // After sleep try again
            t = threadQueue.element();
        }
        // Verified own turn. Update status
        threadQueue.remove();

        // synchronized code #2

        lock.notifyAll(); // Awake any waiting thread after exiting section.
    }