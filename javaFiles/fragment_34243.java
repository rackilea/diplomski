public class A{
  private static A a = new A();
  private static B b = B.getB();

  public static B getB(){
     return b;
  }}

public class B{
  private static B b = new B();
  private static A a = A.getA();

  public static B getB(){
     return b;
  }
}