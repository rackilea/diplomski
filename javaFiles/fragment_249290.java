public class Child extends AbstractBase<SomeClass> {

  public Child() {
    super(SomeClass::new);
  }
}