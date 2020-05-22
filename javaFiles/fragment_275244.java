@SafeVarargs
private static <T> boolean allMatchOneOf(Stream<T> stream, Predicate<T>... predicates) {
    int length = predicates.length;
    BitSet bitSet = new BitSet(length);
    bitSet.set(0, length);
    Iterator<T> it = stream.iterator();
    while (it.hasNext() && !bitSet.isEmpty()) {
        T t = it.next();
        IntStream.range(0, length).filter(i -> !predicates[i].test(t)).forEach(bitSet::clear);
    }
    return !bitSet.isEmpty();
}