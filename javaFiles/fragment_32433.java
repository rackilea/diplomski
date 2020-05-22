class A {
    B b = new B();
}

class B extends A {
}

public class Test {
    public static void main(String[] args) {
        new A(); // Create an A...
                 //   ... which creates a B
                 //   ... which extends A thus implicitly creates an A
                 //   ... which creates a B
                 //   ...
    }
}