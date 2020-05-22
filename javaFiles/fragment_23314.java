public static <E> void sort(
        final List<? extends E> list,
        final Comparator<? super E> comparator,
        final BiFunction<List<? extends E>, Comparator<? super E>, Integer> partitioner) {
    if (list.size() < 2) {
        return;
    }
    final int p = partitioner.apply(list, comparator);
    sort(list.subList(0, p), comparator, partitioner);
    sort(list.subList(p + 1, list.size()), comparator, partitioner);
}

static <E> void lomuto(final List<? extends E> list,
                      final Comparator<? super E> comparator) {
    ContainingClass.<E>sort(list,
         comparator,
         (l,c) -> {
             final E pivot = l.get(l.size() - 1);
             int i = 0;
             for (int j = 0; j < l.size() - 1; j++) {
                 if (c.compare(l.get(j), pivot) <= 0) {
                     swap(l, j, i++);
                 }
             }
             swap(l, l.size() - 1, i);
             return i;
         });
}