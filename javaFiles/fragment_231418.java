public static <T> Predicate<T> distinctByKey(Function<? super T,Object> keyExtractor) {
    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
}

BigDecimal totalShare = orders.stream()
    .filter(distinctByKey(o -> o.getCompany().getId()))
    .map(Order::getShare)
    .reduce(BigDecimal.ZERO, BigDecimal::add);