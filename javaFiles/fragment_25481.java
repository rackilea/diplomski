class Ideone
{
private static <T extends Base> void hassleSafeAdder(Container container, T value) {
        value.addToContainer(container);
    }

public static void main (String[] args) throws java.lang.Exception {
    Container container = new Container();

    hassleSafeAdder(container, new Child1());
    hassleSafeAdder(container, new Child2());
    hassleSafeAdder(container, new Child3());
    hassleSafeAdder(container, new Child4());

}

public static class Container {
    public void add(Child1 obj) { }
    public void add(Child2 obj) { }
    public void add(Child3 obj) { }
    public void add(Child4 obj) { }
}

public static abstract class Base { 

    public abstract void addToContainer(Container container);

}

public static class Child1 extends Base {

    public void addToContainer(Container container) {
        container.add(this);    
    }
}

public static class Child2 extends Base {

    public void addToContainer(Container container) {
        container.add(this);    
    }
}

public static class Child3 extends Base {

    public void addToContainer(Container container) {
        container.add(this);    
    }
}

public static class Child4 extends Base {

    public void addToContainer(Container container) {
        container.add(this);    
    }
}
}