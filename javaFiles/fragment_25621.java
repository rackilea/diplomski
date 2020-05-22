class ClassMap<T> {
  private Map<Class<? extends T>, List<? extends T>> backingMap = new HashMap<>();

  public <E extends T> void put(Class<E> cls, List<E> value) {
    backingMap.put(cls, value);
  }

  @SuppressWarnings("unchecked")
  public <E extends T> List<E> get(Class<E> cls) {
    return (List<E>)backingMap.get(cls);
  }
}