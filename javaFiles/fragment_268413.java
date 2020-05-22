public static class ContainerCache {
  private static final Map<Class<?>, Container<?>> cache = new ConcurrentHashMap<>();

  public static <T> Container<T> getContainer(final Class<T> clazz) {
    return (Container<T>) cache.computeIfAbsent(clazz, c -> new Container<> ((Class<T>) c));
  }
}

public static class Container<T> {
  private final Class<T> clazz;

  public Container(final Class<T> clazz) {
    this.clazz = clazz;
    System.out.println("Expensive constructor for " + this);
  }

  @Override
  public String toString() {
    return String.format("Container [clazz=%s]", clazz);
  }
}