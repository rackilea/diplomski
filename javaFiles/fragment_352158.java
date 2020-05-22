private <E> MultiValuedMap<Boolean, E> partitioningByWithLimit(
                                       Predicate<E> predicate, List<E> src, int limit) {
    MultiValuedMap<Boolean, E> result = new ArrayListValuedHashMap<>();
    result.putAll(false, src);
    List<E> pos = result.get(true);
    result.get(false).removeIf(e -> pos.size()<limit && predicate.test(e) && pos.add(e));
    return result;
}