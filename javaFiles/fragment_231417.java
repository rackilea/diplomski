/**
 * Stateful filter. T is type of stream element.
 */
static class DistinctByKey<T> {
    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
    Function<T,Object> keyExtractor;
    public DistinctByKey(Function<T,Object> ke) {
        this.keyExtractor = ke;
    }
    public boolean filter(T t) {
        return seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
}

BigDecimal totalShare = orders.stream()
    .filter(new DistinctByKey<Order>(o -> o.getCompany().getId())::filter)
    .map(Order::getShare)
    .reduce(BigDecimal.ZERO, BigDecimal::add);