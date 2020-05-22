private static<K,V> void addToMap(Map<K,V> map, Object ... vals, Class<K> keyClass, Class<V> valueClass) {
  for(int i = 0; i < vals.length; i += 2) {
    if (!keyClass.isAssignableFrom(vals[i])) {
      throw new ClassCastException("wrong key type: " + vals[i].getClass());
    }
    if (!valueClass.isAssignableFrom(vals[i+1])) {
      throw new ClassCastException("wrong value type: " + vals[i+1].getClass());
    }

    map.put((K)vals[i], (V)vals[i+1]); //Never throws ClassCastException!
  }
}