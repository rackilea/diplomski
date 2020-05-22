// Producer:
synchronized(queue) {
    while (!queue.isEmpty())
        queue.wait(); //wait for the queue to become empty
    queue.put();
}

//Consumer:
synchronized(queue) {
    queue.get();
    if (queue.isEmpty())
        queue.notify(); // notify the producer
}