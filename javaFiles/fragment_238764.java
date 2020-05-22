public static <K,V> Set<K> keysOfDupValues(Map<K,V> m) {
    Set<K> res = new HashSet<K>();
    Map<V,K> seen = new HashMap<V,K>();
    for (Map.Entry<K,V> e : m.entrySet()) {
        V v = e.getValue();
        K k = e.getKey();
        if (seen.containsKey(v)) {
            res.add(k);
            res.add(seen.get(v));
        } else {
            seen.put(v, k);
        }
    }
    return res;
}