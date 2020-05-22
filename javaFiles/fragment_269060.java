public <T> int indexOfPartition(Collection<T> coll, Function1<T, Boolean> pred, Comparator<T> cmp) {
    final Collection<T> sorted = Collections.sort(coll, cmp);
    final Iterator<T> iter = sorted.iterator();        
    int idx = 0;
    // Walk through the collection until we find an element that is "false"
    // under the predicate (i.e. not in the first partition).
    while (iter.hasNext() && pred(iter.next()) {
        idx++;
    }

    // TODO think about what you want when the collection is empty and/or when
    // the partition never changes (e.g. list of entirely strings starting
    // with "A")
    return idx;
}