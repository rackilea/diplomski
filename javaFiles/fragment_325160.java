public Stream<T> filter2(Predicate<T> p) {
    System.out.println("FILTER2");
    T elem = head.get();
    if (elem == null) {
        return generate(() -> null);
    } else {
        if (p.test(elem)) {
            return new Stream<>(
                () -> elem,
                () -> this.tail.get().filter2(p)
            );
        } else {
            return this.tail.get().filter2(p); // <- not lazy!
        }
    }
}