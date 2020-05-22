abstract class A{
  protected void doTest(){};

  protected abstract String getName();

  public void test() {
    //Shared functionality calling doTest() and doing other stuff. 
    //Can also use getName()
  }
}

abstract class B extends A {}

class C extends B {

    @Override public String getName() { return "C"; }

}

class D extends A {

    @Override public String getName() { return "D"; }

}