public  class ProdCons {
    // Create a queue shared by producer and consumer
    // Size of list is 2.
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2, true);
    int capacity = 2;

    // Function called by producer thread
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            System.out.println("Producer produced-" + value);

            // to insert the jobs in the queue
            // will block in case there is no more space in a queue
            queue.put(value++);
            // and sleep
            Thread.sleep(500);
        }
    }

    // Function called by consumer thread
    public void consume(int thread) throws InterruptedException {
        while (true) {
            //retrieve the first job in the queue
            //will block in case queue is empty, until its not empty
            int val = queue.take();

            System.out.println("Consumer" + thread + " consumed-"
                    + val);

            // and sleep
            Thread.sleep(1000);
        }
    }
}