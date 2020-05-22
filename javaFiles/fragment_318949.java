public class ClassBMockSetter {
  private ClassB classB;
  public void setClassB(ClassB classB) {
    this.classB = classB;
    given(classB.foo()).willReturn(true);
    given(classB.bar()).willReturn(42);
  }
}