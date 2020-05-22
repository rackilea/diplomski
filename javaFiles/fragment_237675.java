public abstract class A<T> {
  private Class<T> typeToken;
  // constructor
  public A() {
        typeToken = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
}