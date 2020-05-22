class MapComparator<K,V extends Comparable<V>> implements Comparator<Map<K,V>> {

  public int compare(Map<K,V> m1, Map<K,V> m2) {
     return m1.get(sortby).compareTo(m2.get(sortby));
  }

}