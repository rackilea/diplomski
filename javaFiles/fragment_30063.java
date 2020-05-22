import groovy.lang.GroovyObject;

public class A {
  public static void main(String[] args) {
    B b = new B();
    if (b instanceof GroovyObject) {
      System.out.println("b is a groovyobject");
      b.yeah();
    } else {
      throw new RuntimeException("b is not a groovyobject");
    }
  }
}