Registration registration = kryo.register(SomeClass.class);
registration.setInstantiator(new ObjectInstantiator<SomeClass>() {
  public SomeClass newInstance () {
    return new SomeClass("some constructor arguments", 1234);
  }
});