// A.java
public class A {
    public static void oneMethod();
}

// B.java
public class B {
    private static void anotherMethod() {
        A.oneMethod();
    }
}