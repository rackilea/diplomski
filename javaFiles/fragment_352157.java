private <E> MultiValuedMap<Boolean, E> partitioningByWithLimit(
                                       Predicate<E> predicate, List<E> src, int limit) {
    MultiValuedMap<Boolean, E> result = new ArrayListValuedHashMap<>();
    for(Iterator<E> iterator = src.iterator(); iterator.hasNext(); ) {
        E next = iterator.next();
        boolean key = predicate.test(next);
        result.put(key, next);
        if(key && --limit==0) iterator.forEachRemaining(result.get(false)::add);
    }
    return result;
}