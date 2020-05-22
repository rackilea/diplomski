class Super {
  protected Super() {
    doSomeStuff();
  }

  protected abstract void doSomeStuff();
}

class Sub extends Super {
  private int number = 1;

  public Sub() {
    super();
    System.out.println("in Sub(): " + number);
  }

  protected doSomeStuff() {
    System.out.println("in doSomeStuff(): " + number);
  }
}