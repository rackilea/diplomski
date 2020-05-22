/** Produces random Strings */
class RandomStringProducer {
    Random random = new Random();
    public String produceString() {
        return Double.toString(random.nextDouble());
    }
}

/** Prints a String */
class PrintConsumer implements StringConsume {
    public void accept(String s) { System.out.println(s); }
}

/** Consumes String by putting it into a queue */
class QueueProducer implements StringConsume {
    BlockingQueue<String> queue;
    public QueueProducer(BlockingQueue<String> q) { queue = q; }
    public void accept(String s) {
        queue.put(s);
    }
}

public static void main(String[] args) {
    // the producer
    RandomStringProducer producer = new RandomStringProducer();

    // the end consumer
    StringConsume printConsumer = new PrintConsumer();

    // the queue that links producer and consumer
    BlockingQueue<String> queue = new ArrayBlockingQueue<>();

    // the consumer putting strings into the queue
    QueueProducer queuePutter = new QueueProducer(queue);

    // now, let's tie them together

    // one thread to produce strings and put them into the queue
    ScheduledExecutorService producerService = Executors.newScheduledThreadPool(1);
    Runnable createStringAndPutIntoQueue = () -> {
        String created = producer.createString();
        queuePutter.consume(created);
    };
    // put string into queue every 100ms
    producerService.scheduleAtFixedRate(createStringAndPutIntoQueue, 100, TimeUnit.MILLISECONDS);

    // one thread to consume strings
    Runnable takeStringFromQueueAndPrint = () -> {
        while(true) {
            String takenFromQueue = queue.take(); // this will block until a string is available
            printConsumer.consume(takenFromQueue);
        }
    };
    // let it run in a different thread
    ExecutorService consumerService = Executors.newSingleThreadExecutor();
    consumerService.submit(takeStringFromQueueAndPrint);

    // this will be printed; we are in the main thread and code is still being executed
    System.out.println("the produce/consume has started");
}