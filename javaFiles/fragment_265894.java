BlockingQueue<MyObject> myQueue;
    // A constructor which receives the BlockingQueue object

    // Main Loop
    boolean isInterrupted = false;

    while(!isInterrupted) {
        try {
            MyObject object = myQueue.take();   // Will block
            // Process object
        } catch (InterruptedException e) {
            isInterrupted = true;
        }
    }