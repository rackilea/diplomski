class QueueConsumer implements Runnable {
    @Override
    public void run() {
        while(!(Thread.currentThread().isInterrupted())) {
            try {
                final ComplexObject complexObject = myBlockingQueue.take();
                this.process(complexObject);

            } catch (InterruptedException e) {
                // Set interrupted flag.
                Thread.currentThread().interrupt();
            }
        }

        // Thread is getting ready to die, but first,
        // drain remaining elements on the queue and process them.
        final LinkedList<ComplexObject> remainingObjects;
        myBlockingQueue.drainTo(remainingObjects);
        for(ComplexObject complexObject : remainingObjects) {
            this.process(complexObject);
        }
    }

    private void process(final ComplexObject complexObject) {
        // Do something with the complex object.
    }
}