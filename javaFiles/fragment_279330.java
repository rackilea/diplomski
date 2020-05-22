public static SortedMap<K,V> putFirstEntries(int max, SortedMap<K,V> source) {
  int count = 0;
  TreeMap<K,V> target = new TreeMap<K,V>();
  for (Map.Entry<K,V> entry:source.entrySet()) {
     if (count >= max) break;

     target.put(entry.getKey(), entry.getValue());
     count++;
  }
  return target;
}