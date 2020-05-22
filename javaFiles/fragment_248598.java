class MyJaxRSApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    return Collections.singletonSet(MyClass.class);
  }

  @Override
  public Set<Object> getSingletons() {
    return Collections.singletonSet(new MyBinder(new MyStateImpl()));
  }
}