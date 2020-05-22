@SupressWarnings("unchecked")
public static <K, V, M extends Map<K, V>> M deepCopyMap(M s) {
    Map map;
    if(s.getClass() == HashMap.class) {
      map = new HashMap();
    } else if(s.getClass == LinkedHashMap.class) {
      map = new LinkedHashMap();
    } else {
      throw new RuntimeException("unknown map type " + s.getClass());
    }
    for(Map.Entry<K, V> entry : source.entrySet()) {
        K k = entry.getKey();
        V v = entry.getValue();
        if(k instanceof Map) {
          map.put(k, deepCopyMap((Map) k));
        } else {
          result.put(k, v);
        }
    }
    return (M) map;
}