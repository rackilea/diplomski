abstract class InterfaceDelegator implements Interface {
  protected final Interface primary;
  public InterfaceDelegator() {
    this.primary = primary;
  }
  // implements all the calls as: primary.call(...)
}

class Helper extends InterfaceDelegator {
  // override just the methods you need
}