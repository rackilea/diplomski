interface Producer<T> {
    T get();
}

class NumberProducer<T extends Number> implements Producer<T> {
    @Override
    public T get() { return null; }
}

class IntegerProducer extends NumberProducer<Integer> { // Implicit: implements Producer<Integer>
    @Override
    public Integer get() { return null; }
}