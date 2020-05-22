import static path.to.SomeTypeBinder.bindSomeTypeSetElement;

public void configure() {
  bindSomeTypeSetElement(binder()).toInstance(new ConcreteType());
  bindSomeTypeSetElement(binder()).to(SecondConcreteType.class);
  bindSomeTypeSetElement(binder()).toProvider(new ThirdConcreteTypeProvider());
}