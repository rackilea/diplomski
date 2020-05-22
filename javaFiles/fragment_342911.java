package package2;

import package1.MyClass;

public class MyClassImpl extends MyClass {
  @Override
  protected String method1() {
    return "protected method";
  }

  @Override
  public String method2() {
    return "public method";
  }
}