private Map<String, ?> map;

public <V> void createMap(Class<V> clazz) {
   map = Collections.checkedMap(new HashMap<String, V>(),
      String.class, clazz);
}