Thread producerThread = new Thread(new Producer(q));
producerThread.start();     
Thread consumerThread = new Thread(new Consumer(q));
consumerThread.start();
try {
    producerThread.join();
} finally {
    consumerThread.interrupt();
}