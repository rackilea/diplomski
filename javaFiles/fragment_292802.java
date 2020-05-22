class MyClass {

  protected static <T> Set<T> SetFactory(int size)
  {
    return new HashSet<T>(size);
  }

  protected static <K, V> Map<K, Set<V>> mapFactory(Collection<K> keys)
  {
    Map<K, Set<V>> result = new HashMap<K, Set<V>>(keys.size());
    for (K key : keys)
      result.put(key, MyClass.<V>SetFactory(20));
    return result;
  }

}