abstract class AbstractHashCodeAccumulator<T> implements Accumulator<T, Integer>
{
    private int accumulator = 0;
    abstract protected int combine(int a, int h);
    abstract protected int uncombine(int a, int h);
    @Override public void add(T t) { accumulator = combine(accumulator, t.hashCode());
    @Override public void subtract(T t) { accumulator = uncombine(accumulator, t.hashCode());
    @Override public Integer get() { return accumulator; }
}

class SumHasher extends AbstractHashCodeAccumulator<String>
{
    @Override protected int combine(int a, int h)   { return a+h; }
    @Override protected int uncombine(int a, int h) { return a-h; }
}

class XorHasher extends AbstractHashCodeAccumulator<String>
{
    @Override protected int combine(int a, int h)   { return a^h; }
    @Override protected int uncombine(int a, int h) { return a^h; }
}