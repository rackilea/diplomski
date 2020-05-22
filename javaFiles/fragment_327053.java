class A {
    public void method1(A X) {
        System.out.println("A");      <--|
    }                                    |
}                                        |
class B extends A {                      |
    public void method2() {              | This is the only overriding happening
        System.out.println("B");         | because they share the signature method1(A)
    }                                    | The other signatures are method1() from class B
}                                        | and method1(D) from class D
class C extends B {                      |
    public void method1(A x) {           |
        System.out.println("C");         |
    }                             -------
}
class D extends C {
    public void method1(D x) {
        System.out.println("D");
    }
}
public class test {
    public static void main(String[] args) {
        C c = new D();
        B b = c;
        c.method1(c);  // prints C
        b.method1(b);  // prints C
    }
}