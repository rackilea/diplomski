class ProducerConsumerStarter
{
    private static final ExecutorService CONSUMERS = Executors.newFixedThreadPool(8); 
    private static final ExecutorService PRODUCERS = Executors.newFixedThreadPool(8); 

    public static List<Future<Void>> startIntegerProducerConsumer(int producers, int consumers) {
        ...
    }
}