public abstract class Parent {
    protected Parent(String name) {
        this.name = name;
    }
    public getName() {return name;}
}
public class Child1 extends Parent {
    public Child1() {
        super("Jon");
    }

}
public class Child2 extends Parent {
    public Child2() {
        super("Mary");
    }
}