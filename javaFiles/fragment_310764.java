public class FooMapper {

  private Map<Class<?>, Foo<?>> fooMap = new HashMap<>();

  public <T> void setFoo(Class<T> clazz, Foo<T> foo) {
    fooMap.put(clazz, foo);
  }

  @SuppressWarnings("unchecked")
  public <T> Foo<T> getFoo(Class<T> clazz) {
    return (Foo<T>) fooMap.get(clazz);
  }

}