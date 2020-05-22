public static void main(String[] args) throws InterruptedException {
        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Producer producer = new Producer(sharedQueue);
        Thread prodThread = new Thread(producer);
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();

        producer.pushItem(2000);
    }