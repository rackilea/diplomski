class MyClass<T> {

  private final Constructor<? extends T> ctor;

  private T field;

  MyClass(Class<? extends T> impl) throws NoSuchMethodException {
    this.ctor = impl.getConstructor();
  }

  public void myMethod() throws Exception {
    field = ctor.newInstance();
  }

}