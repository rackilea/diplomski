class A {
  public void f() {}
  public void h() {} 
  public void i() {} 
}

class B extends A {
  public void g() { f(); } // same as super.f()
  public void h() { h(); /* recursive call */ }
  public void i() { super.i(); /* call to inherited but "masked" */ }
}