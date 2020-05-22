public static <TKey, TValue, TMap extends Map<TKey, TValue>> TMap map(TMap map, Pair<? extends TKey, ? extends TValue>... pairs) {
    for (Pair<? extends TKey, ? extends TValue> pair: pairs) {
        map.put(pair.getKey(), pair.getValue());
    }
    return map;
}

public static <TKey, TValue> HashMap<TKey, TValue> map(Pair<? extends TKey, ? extends TValue>... pairs) {
    return map(new HashMap<TKey, TValue>(), pairs);
}