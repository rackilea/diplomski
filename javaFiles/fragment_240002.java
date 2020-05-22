package de.scrum_master.app;

import org.springframework.stereotype.Component;

@Component
public class MyImpl implements X, Y {
  @Override public void methodY1() { System.out.println("Y1"); methodX2("bar"); }
  @Override public String methodY2(int i) { System.out.println("Y2"); return "dummy"; }
  @Override public void methodY3(SomeType s) { System.out.println("Y3"); }
  @Override public void methodX1() { System.out.println("X1"); methodY1(); }
  @Override public int methodX2(String s) {  System.out.println("X2"); return 42; }

  public static void main(String[] args) {
    MyImpl myImpl = new MyImpl();
    myImpl.methodX1();
    myImpl.methodX2("foo");
    myImpl.methodY1();
    myImpl.methodY2(11);
    myImpl.methodY3(new SomeType());
  }
}