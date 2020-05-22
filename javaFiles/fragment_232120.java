class Parent {
    private final String className;
    protected Parent(String className) {
         this.className = className;
    }
}

public class Child extends Parent {
    public Child() {
        super("Child");
    }
}