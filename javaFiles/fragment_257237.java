public class Bar<T extends Foo> {
  private final Class<T> clazz;

  public class Bar(Class<T> clazz) {
    this.clazz = clazz;
  }

  public T newInstance() {
    return clazz.newInstance(); // this will throw checked exceptions
  }
}