public class Test {
  public static void main(String[] args) {
    Foo foo = new Foo();
    Spy spy = new Spy();
    System.out.println(spy.getBaz(foo));
  }
}