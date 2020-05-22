// A.java
public class A {
    static void oneMethod();
}

// B.java
public class B {
    private static void anotherMethod() {
        A.oneMethod();
    }
}