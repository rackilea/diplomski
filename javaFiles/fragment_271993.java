public MappingRegistry<K,V> {

   private final Map<K,V> mappings = new HashMap<K,V>();

   public void addMapping(K key, V value) {
      mappings.put(key, value);
   }

   public Map<K,V> getMappings() {
      return Collections.unmodifiableMap(mappings);
   }
}