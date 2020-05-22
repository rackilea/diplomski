private <E> MultiValuedMap<Boolean, E> partitioningByWithLimit(
                                       Predicate<E> predicate, List<E> src, int limit) {
    MultiValuedMap<Boolean, E> result = new ArrayListValuedHashMap<>();
    for(E next: src) {
        boolean key = limit>0 && predicate.test(next);
        result.put(key, next);
        if(key) limit--;
    }
    return result;
}