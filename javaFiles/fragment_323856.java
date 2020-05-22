class A {
  String getVal(){
    return "from a";
  }
}
class B extends A {

}
public class C {
  public static void main(String [] args) {
    B x = new B();
    x.getVal();
  }
}