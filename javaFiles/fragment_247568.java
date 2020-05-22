public class A {
    public A() { 
        // Whatever
    }

    public A(A a) {
        // Use the existing values in "a" to initialize this object
    }
}

public class B extends A {
    /** Creates a new B from the values in an A, with suitable defaults. */
    public B(A a) {
        super(a);
        // Now initialize any fields in B with appropriate values
    }
}