public class Parent {
    public Parent(EventObject source) {
        // initialize parent ...
        source.subscribe(this::someMethod);
    }
    public void someMethod() {
        ...
    }
...
}

public class Child extends Parent {
    public Child(EventObject source) {
        super(source);
        // initialize child ...
    }
...
}