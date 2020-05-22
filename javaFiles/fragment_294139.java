public static <K, V> Collection<K> findKeysOfEqualValues(Map<K, V> map1, Map<K, V> map2) {
    Set<K> keyList = new LinkedHashSet<>();
    for(Map.Entry<K, V> mapEntry1 : map1.entrySet()) {
        for(Map.Entry<K, V> mapEntry2 : map2.entrySet()) {
            if(Objects.equals(mapEntry1.getValue(), mapEntry2.getValue())) {
                keyList.add(mapEntry1.getKey());
                keyList.add(mapEntry2.getKey());
            }
        }
    }

    return keyList;
}