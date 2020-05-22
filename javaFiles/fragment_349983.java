public class MyPublicEjb {
  @EJB
  private MyPrivateImpl impl;

  public void doSomething() {
    try {
      impl.doSomething();
    } catch(TXRolledBack) {
      // handle rollback ...
    }
  }
}