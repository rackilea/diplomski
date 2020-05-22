public class FinalTest {
  private final Object a;
  //Constructor
  public FinalTest() {
    setA();
  }

  private void setA() {
    a = new Object;
  }

  public void doSomething() {
   this.setA(); // not good because a is final
  }
}