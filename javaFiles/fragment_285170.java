class MyMap<K,V> {
   private Map<K,V> map;

   public V get(K key) { return map.get(key); }

   // all the methods of map have been wrapped
}