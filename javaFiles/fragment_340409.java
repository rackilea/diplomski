public class GenericClass<T> {
  private final Class<? extends T> clazz;
  public GenericClass(Class<? extends T> clazz) {
    this.clazz = clazz;
  }
  void foo() {
    T t = clazz.newInstance();
  }
}