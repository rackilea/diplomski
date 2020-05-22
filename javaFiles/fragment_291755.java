public static <K, V, M extends Map<K, V>> M toMap(
    K[] keys, 
    V[] values, 
    Supplier<M> factory) {

    return IntStream.range(0, keys.length).boxed().collect(
        Collectors.toMap(i -> keys[i], i -> values[i], (a, b) -> a, factory));
}