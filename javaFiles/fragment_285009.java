class Parent {
    public void method() {
        System.out.println("Parent: method");
    someOtherMethod();
    }
    public void someOtherMethod() {
        System.out.println("Parent: some other");
    }
}


class Child extends Parent {

    @Override
    public void method() {
        System.out.println("Child: method");
        super.method();
    }

    @Override
    public void someOtherMethod() {
        System.out.println("Child: some other");
    }
}

public class Test {
    public static void main(String[] args) {
        new Child().method();
    }
}