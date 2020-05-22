public final class StepRange
    implements Spliterator.OfInt
{
    private final int start;
    private final int end;
    private final int step;

    private int currentValue;

    public StepRange(final int start, final int end, final int step)
    {
        this.start = start;
        this.end = end;
        this.step = step;
        currentValue = start;
    }

    @Override
    public OfInt trySplit()
    {
        return null;
    }

    @Override
    public long estimateSize()
    {
        return Long.MAX_VALUE;
    }

    @Override
    public int characteristics()
    {
        return Spliterator.IMMUTABLE | Spliterator.DISTINCT;
    }

    @Override
    public boolean tryAdvance(final IntConsumer action)
    {
        final int nextValue = currentValue + step;
        if (nextValue > end)
            return false;
        action.accept(currentValue);
        currentValue = nextValue;
        return true;
    }
}