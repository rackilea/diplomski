public class MyClass<T> {
  private final Class<T> clazz;

  public MyClass(Class<T> c) {
    if (c == null) {
      throw new NullPointerException("class cannot be null");
    }
    clazz = c;
  }

  public void printT() {
    System.out.println(clazz.getName());
  }
}