class Producer implements Runnable {
    Monitor producer;
    public Producer(Monitor m) {
        producer = m;
    }
    @Override
    public void run() {
        producer = new Monitor(); // REMOVE THIS

class Consumer implements Runnable {
    Monitor consumer;
    public Consumer(Monitor m) {
        consumer = m;
    }
    @Override
    public void run() {
        System.out.println("Consumer created");
        consumer = new Monitor(); // AND REMOVE THIS