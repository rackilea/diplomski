class RandomIntegerProducer implements Runnable
{
    private final BlockingQueue<? super Integer> queue;
    private final Random random;
    ...
    @Override
    public void run()
    {
        queue.offer(random.nextInt());
    }
}