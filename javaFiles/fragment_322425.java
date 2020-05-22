final class FooElementWrapper {

  private final FooElement inner;
  public FooElementWrapper(FooElement inner) {
    this.inner = inner;
  }

  @Override
  public int hashCode() {
    return 0; // replace by a proper implementation!!!
  }

  @Override
  public boolean equals(Object o) {
    if(o instanceof FooElementWrapper) {
      return this.isEqualTo((FooElementWrapper)o);
    } else {
      return false;
    }
  }

}