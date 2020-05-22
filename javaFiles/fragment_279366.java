class Builder<K,V> {
   final Map<K,V> map = new HashMap<K,V>();

   Builder add(V value, K... keys) {
      for(K key : keys) {
         map.put(key, value);
      }
      return this;
   }

   Map<K,V> build() {
      return Collections.unmodifiableMap(new HashMap<K,V>(map));
   }
}

// Usage:
mapperMap = new Builder<String,String>()
   .add("Bar1", "Foo1", "Foo2")
   .add("Bar2", "Foo3")
   ...
   .build();