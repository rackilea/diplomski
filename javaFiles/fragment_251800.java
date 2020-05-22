class MyClass<T> {

  private final Supplier<? extends T> ctor;

  private T field;

  MyClass(Supplier<? extends T> ctor) {
    this.ctor = Objects.requireNonNull(ctor);
  }

  public void myMethod() {
    field = ctor.get();
  }

}