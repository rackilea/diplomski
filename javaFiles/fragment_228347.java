// remove any duplicated values, leaving one entry.
public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
     Map<K,V> map2 = invert(invert(map));
     map.clear();
     map.putAll(map2);
}

public static <K, V> Map<V, K> invert(Map<K, V> map) {
     Map<V, K> map2 = new HashMap<>();
     for(Map.Entry<K< V> entry: map.entrySet())
         map2.put(entry.getValue(), entry.getKey());
     return map2;
}