public abstract class A {
    @BeforeMethod
    public void setupA() { }
}

public class B extends A {
    @BeforeMethod
    public void setupB() { }

    @Test
    public void foo() { }
}