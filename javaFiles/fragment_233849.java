public class A {
  public class B {}
  protected void method(B b) {
    System.out.println("A#method");
  }
}

class C extends A {
  override def method(b: B): Unit = {
    println("C#method")
    super.method(b)
  }
}