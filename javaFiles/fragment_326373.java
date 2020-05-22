public class Parent {
    public static Parent newInstance(EventObject source) {
        Parent p = new Parent();
        source.subscribe(p::someMethod);
        return p;
    }        
    protected Parent() {
        // initialize parent ...
    }
    public void someMethod() {
        ...
    }
...
}

public class Child extends Parent {
    public static Child newInstance(EventObject source) {
        Child c = new Child();
        source.subscribe(c::someMethod);
        return c;
    }    
    protected Child() {
        super();
        // initialize child ...
    }
...
}