public abstract class Fruit {
    public Fruit(String name) {
       //stuff...
    }

    public void someMethod1() { }
}

public class Lemon extends Fruit {
    public Lemon() {
        // child class constructor calling superclass constructor
        super("John");

        // child class constructor calling own method:
        someMethod2();

        // child class constructor calling superclass method:
        someMethod1();
    }

    public void someMethod2() { }
}