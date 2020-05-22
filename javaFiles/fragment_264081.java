public class A {
  private B b;

  /*
  *  Used by clients
  */
  public A() {
    this(new B());
  }

  /*
  * Used by unit test
  * 
  * @param b A mock implementation of B
  */
  A(B b) {
    this.b = b;
  }
}