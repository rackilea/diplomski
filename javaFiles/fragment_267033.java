public static <K, V> Map<K, V> reduce(Map<K, V>... maps) {
    return Arrays.stream(maps)
            .collect(HashMap::new, Map::putAll, Map::putAll);
            //                          ^            ^
            //                          |         collect results from parallel streams
            //                       collect results in single thread
}