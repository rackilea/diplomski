// in the setup
BlockingQueue<String> queue = new LinkedBlockingQueue<>();

// in producer thread
queue.put(work);

// in consumer thread
work = queue.take(); // blocking - waits as long as needed