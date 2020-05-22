public class C {

  public static void main(String[] args) {
    A a = new A();
    B b = new B();
    a.setB(b);

    a.listenerMethod();

  }
}