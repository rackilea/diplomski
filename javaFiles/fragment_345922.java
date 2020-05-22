public static <E> Stream<List<E>> combinationsDupl(List<E> l, int size) {
    if (size == 0) {
        return Stream.of(Collections.emptyList()); 
    } else {
        return l.stream().<List<E>> flatMap(h -> combinationsDupl(subtract(l, h), size - 1).map(t -> pipe(h, t)));
    }
}

private static <E> List<E> pipe(E head, List<E> tail) {
    List<E> newList = new ArrayList<>(tail);
    newList.add(0, head);
    return newList;
}

private static <E> List<E> subtract(List<E> list, E e) {
    List<E> newList = new ArrayList<>(list);
    newList.remove(e);
    return newList;
}