public static <E> Stream<List<E>> combinations(List<E> l, int size) {
    if (size == 0) {
        return Stream.of(Collections.emptyList()); 
    } else {
        return IntStream.range(0, l.size()).boxed().
            <List<E>> flatMap(i -> combinations(l.subList(i+1, l.size()), size - 1).map(t -> pipe(l.get(i), t)));
    }
}

private static <E> List<E> pipe(E head, List<E> tail) {
    List<E> newList = new ArrayList<>(tail);
    newList.add(0, head);
    return newList;
}