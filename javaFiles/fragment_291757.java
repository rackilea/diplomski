public static <K, V, M extends Map<K, V>> Pair<K[], V[]> toArrays(
    M map, 
    IntFunction<K[]> keysFactory,
    IntFunction<V[]> valuesFactory) {

    K[] keys = map.keySet().stream().toArray(keysFactory);
    V[] values = map.values().stream().toArray(valuesFactory);
    return new Pair<>(keys, values);
}