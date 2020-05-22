// file: A.java
public class A { public static void main(String[] args) { new B().run(); } }

// file: B.java
public class B { void run() { new C().run(); } }

// file: C.java
public class C { void run() { System.out.println("hello world"); } }