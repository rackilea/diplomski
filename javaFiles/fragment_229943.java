//copy paste from linked site
public static <K, V> Map.Entry<K, V> entry(K key, V value) {
    return new AbstractMap.SimpleEntry<>(key, value);
}

public static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, U>> entriesToMap() {
    return Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue());
}

Map<Integer, String> map = Stream.of(
            entry(0, "zero"),
            //...
            entry(12, "twelve"))
            .collect(entriesToMap());