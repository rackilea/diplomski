package org.bar;

public class C {
  void test() {
    B b = new B();

    int f = b.field;          // visible
    B.Inner = b.new Inner();  // visible
    b.method();               // visible
  }
}