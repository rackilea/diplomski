class MyHouse {
    final BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    void eatFood() throws InterruptedException {
        // take next item from the queue (sleeps while waiting)
        Object food = queue.take();
        // and do something with it
        System.out.println("Eating: " + food);
    }

    void deliverPizza() throws InterruptedException {
        // in producer threads, we push items on to the queue.
        // if there is space in the queue we can return immediately;
        // the consumer thread(s) will get to it later
        queue.put("A delicious pizza");
    }
}