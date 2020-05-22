public class A {
    protected String property;
}

public class B extends A {
    private String property;

    public void foo() {
        // Property of B
        System.out.println(property);
        // The same
        System.out.println(this.property);

        // Property of A
        System.out.println(super.property);
    }
}