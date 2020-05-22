interface Accumulator<T, U>
{
    public void add(T t);
    public void subtract(T t);
    public U get();
}

class SumHasher implements Accumulator<String,Integer>
{
    @Override private int accumulator = 0;
    @Override public void add(String t) { accumulator += t.hashCode(); }
    @Override public void subtract(String t) { accumulator -= t.hashCode(); }
    @Override public Integer get() { return accumulator; }
}

class XorHasher implements Accumulator<String,Integer>
{
    @Override private int accumulator = 0;
    @Override public void add(String t) { accumulator ^= t.hashCode(); }
    @Override public void subtract(String t) { accumulator ^= t.hashCode(); }
    @Override public Integer get() { return accumulator; }
}