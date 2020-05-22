class A {
  public A foo() {
    System.out.println("in A");
    return this;
  }
}

class B extends A {
  @Override
  public B foo() {
    System.out.println("in B");
    return this;
  }
}