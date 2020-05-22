public class FailingExaple {
    @org.junit.Test
    public void deadlockApplication() throws Exception
    {
        List<Future<Void>> futures = ProducerConsumerStarter.startIntegerProducerConsumer(10, 10);
        for (Future<Void> future : futures)
        {
            System.out.println("Getting future");
            future.get();
        }
    }
}