@SuppressWarnings("unchecked")
public static <T> Stream<T> generateRest(Stream<T> stream, BinaryOperator<T> binaryOperator) {
    T[] t = (T[]) stream.toArray();
    if (t.length == 1) {
        t = (T[]) new Object[] { t[0], binaryOperator.apply(t[0], t[0]) };
    }
    final T[] items = t;
    return Stream.generate(() -> {
        T first = items[0];
        T next = binaryOperator.apply(items[0], items[1]);
        System.arraycopy(items, 1, items, 0, items.length - 1);
        items[items.length - 1] = next;
        return first;
    });
}