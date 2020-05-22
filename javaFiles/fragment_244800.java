public class BeanImpl {
  ...
  public BeanImpl(Object param) {
    if (param == null) {
      throw new IllegalArgumentException("Param cannot be null");
    }
    foo = param;
  }
  ...
}