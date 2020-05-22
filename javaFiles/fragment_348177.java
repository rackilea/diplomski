public class A extends MIDlet {
  B b;

  public A() {
    b = new B(this);
  }
}

class B {
  A a;

  B(A a) {
    this.a = a;
  }

  public void commandAction(Command c, Displayable d) {
    switchDisplayable(null, a.getFormA());
  }
}