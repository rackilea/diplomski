@SafeVarargs
public static <T> long streamForked(Stream<T> source, Consumer<Stream<T>>... consumers)
{
    return StreamSupport.stream(new ForkingSpliterator<>(source, consumers), false).count();
}

private static class ForkingSpliterator<T>
    extends AbstractSpliterator<T>
{
    private Spliterator<T>   sourceSpliterator;

    private BlockingQueue<T> queue      = new LinkedBlockingQueue<>();

    private AtomicInteger    nextToTake = new AtomicInteger(0);
    private AtomicInteger    processed  = new AtomicInteger(0);

    private boolean          sourceDone;
    private int              consumerCount;

    @SafeVarargs
    private ForkingSpliterator(Stream<T> source, Consumer<Stream<T>>... consumers)
    {
        super(Long.MAX_VALUE, 0);

        sourceSpliterator = source.spliterator();
        consumerCount = consumers.length;

        for (int i = 0; i < consumers.length; i++)
        {
            int index = i;
            Consumer<Stream<T>> consumer = consumers[i];
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    consumer.accept(StreamSupport.stream(new ForkedConsumer(index), false));
                }
            }).start();
        }
    }

    @Override
    public boolean tryAdvance(Consumer<? super T> action)
    {
        sourceDone = !sourceSpliterator.tryAdvance(queue::offer);
        return !sourceDone;
    }

    private class ForkedConsumer
        extends AbstractSpliterator<T>
    {
        private int index;

        private ForkedConsumer(int index)
        {
            super(Long.MAX_VALUE, 0);

            this.index = index;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action)
        {
            // take next element when it's our turn
            while (!nextToTake.compareAndSet(index, index + 1))
            {
            }
            T element;
            while ((element = queue.peek()) == null)
            {
                if (sourceDone)
                {
                    // element is null, and there won't be no more, so "terminate" this sub stream
                    return false;
                }
            }

            // push to consumer pipeline
            action.accept(element);

            if (consumerCount == processed.incrementAndGet())
            {
                // start next round
                queue.poll();
                processed.set(0);
                nextToTake.set(0);
            }

            return true;
        }
    }
}