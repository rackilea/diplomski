package package2;

import package1.MyClass;

public class MainClass {
  static MyClass myClass = new MyClassImpl();

  public static void main(String[] args) {
    System.out.println(myClass.method1());   // This is compilation error.
    System.out.println(myClass.method2());
  }
}