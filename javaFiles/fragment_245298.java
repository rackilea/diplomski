List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>(map.entrySet());
Collections.sort(entries, new Comparator<Entry<K, V>>() {
  public int compare(Entry<K, V> left, Entry<K, V> right) {
    return left.getValue().compareTo(right.getValue());
  }
}
Map<K, V> sortedMap = new LinkedHashMap<K, V>(entries.size());
for (Entry<K, V> entry : entries) {
  sortedMap.put(entry.getKey(), entry.getValue());
}