class Superclass {
    public void foo() {
        bar();
    }

    public void bar() {
        System.out.println("Superclass.bar()");
    }
}

class Subclass extends Superclass {
    @Override
    public void bar() {
        System.out.println("Subclass.bar()");
    }
}

public class Test {

    public static void main(String [] args) {
        Superclass x = new Subclass();
        x.foo(); // Prints Subclass.bar()
    }
}