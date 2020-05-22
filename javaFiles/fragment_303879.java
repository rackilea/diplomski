public final class Lazy<T> {

  private final Supplier<? extends T> initializer;
  private volatile T value;

  public Lazy(Supplier<? extends T> initializer) {
    this.initializer = initializer;
  }

  public T get() {
    T result = this.value;
    if (result == null) {
      synchronized (this) {
        result = this.value;
        if (result == null) {
          this.value = result = this.initializer.get();
        }
      }
    }
    return result;
  }

}