/**
 * Stateful filter. T is type of stream element, K is type of extracted key.
 */
static class DistinctByKey<T,K> {
    Map<K,Boolean> seen = new ConcurrentHashMap<>();
    Function<T,K> keyExtractor;
    public DistinctByKey(Function<T,K> ke) {
        this.keyExtractor = ke;
    }
    public boolean filter(T t) {
        return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}