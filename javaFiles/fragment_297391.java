private final Map<String, List<?>> properties = new HashMap<>();
private final Map<String, Class<?>> propClasses= new HashMap<>();

public <T> void put(final String key, final List<T> value, final Class<T> elementClass) {
  properties.put(key, value);
  propClasses.put(key, elementClass);
}