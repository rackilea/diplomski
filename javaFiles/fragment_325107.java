public class A extends java.util.Observable {
  private B property1;
  private C property2;
  int variable1;

  public void doThatThingy() {
    property1.doSomething();
    notifyObservers();
  }
}

public class B {
  void doSomething() {
    // Hey look at me, I'm doing something
  }
}