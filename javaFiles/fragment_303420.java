class DynamicAnswer<T> implements Answer {
    T currentValue;
    UnaryOperator<T> adjustment;
    public DynamicAnswer(T seed, UnaryOperator<T> ad) {
        currentValue = seed;
        adjustment = ad;
    }
    public Object answer(InvocationOnMock invocation) {
        T result = currentValue;
        currentValue = adjustment.apply(currentValue);
        return result;
    }
}