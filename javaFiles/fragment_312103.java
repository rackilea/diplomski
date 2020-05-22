class A {
  public void foo(A a) {
    System.out.println("in A");
  }
}


class B extends A {

  @Override
  public void foo(B b) {
    System.out.println("in B");
  }
  @Override
  public void foo(Object o) {
    System.out.println("in B");
  }
}