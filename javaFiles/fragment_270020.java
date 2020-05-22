List<Foo> transformValue(List<Foo.Builder> value) {
     //original value transformation logic
 }

 <K,V> Entry<K,V> pair(K key, V value){ 
    return new AbstractMap.SimpleEntry<>(key, value);
 }

 strFooMap.entrySet().stream()
      .map(entry -> pair(entry.getKey(), transformValue(entry.getValue()))
      .filter(entry -> !entry.getValue().isEmpty())
      .collect(toMap(Entry::getKey, Entry::getValue));