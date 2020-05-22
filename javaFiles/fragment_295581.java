public class Parent {
    private int x = 10; // <-- this also works if protected

    public void foo() {
        System.out.printf("x = %d ", x);        
    }
}

public class Child extends Parent {
    private int x = 20;

    @Override
    public void foo() {
        super.foo();
        System.out.printf("x = %d ", x);
    }
}