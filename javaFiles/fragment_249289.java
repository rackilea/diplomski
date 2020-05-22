public abstract class AbstractBase<T> {

  private final T genericTypeObject;

  public AbstractBase(Supplier<T> supplier) {
    genericTypeObject = supplier.get();
  }
}