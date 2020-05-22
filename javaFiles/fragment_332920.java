public class MyClass<E> {
  public static void myMethod(Object item) {
    // Compiler error
    if (item instanceof E) {
        ...
    }
    E item2 = new E();       // Compiler error
    E[] iArray = new E[10];  // Compiler error
    E obj = (E)new Object(); // Unchecked cast warning
  }
}