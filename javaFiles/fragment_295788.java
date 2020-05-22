final int maxClient = 5;
AtomicInteger clientCount = new AtomicInteger(0);
ConcurrentLinkedQueue<Client> queue = new ConcurrentLinkedQueue<>(); // hold waiting clients
while(true) {
    int temp = clientCount.intValue();
    if(!queue.isEmpty() && clientCount.compareAndSet(temp, temp + 1) { // thread-safe increment 
        process(clients.poll()); // don't forget to decrement the clientCount when the processing finishes
    } else Thread.sleep(500);
}