// keep the sort method unchanged

static <E> void lomuto(final List<? extends E> list,
                      final Comparator<? super E> comparator) {
    sort(list,
         comparator,
         (List<? extends E> l, Comparator<? super E> c) -> {
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