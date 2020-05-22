public interface A {
    void test1();
    void test2();
}

public abstract class B implements A {
{
    public void test1() { // do something here; concrete implementation }
    // Note: Nothing for test2.  
    // Compiler doesn't complain because it's an abstract class, and this is an abstract method.
}

public class C extends B {
    // Note: nothing for test1 - get it from abstract superclass
    // Note: compiler will complain if nothing is done to implement test2(), because C isn't abstract
    public void test2() { // do something here; concrete implementation }
}