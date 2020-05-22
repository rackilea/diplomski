private static class OutValue<T> {
    public T value;

    static <X> OutValue<X> makeOutValue(X value) {
        OutValue<X> outValue = new OutValue<X>();
        outValue.value = value;
        return outValue;
    }
}