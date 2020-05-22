public class Test {

    public static void main(String... args) {
        new Test().test();
    }

    private void test() {
        Parent a = new ChildA();
        getNewInstance(a);

        Parent b = new ChildB();
        getNewInstance(b);
    }

    // T extends Parent makes sure we can only pass in subclasses of Parent
    static <T extends Parent> T getNewInstance(T oldInstance) {
        Class<T> theClass = (Class<T>) oldInstance.getClass();

        try {
            return theClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class Parent {}

class ChildA extends Parent {
    public ChildA() { System.out.println("New ChildA created."); } 
}

class ChildB extends Parent {
    public ChildB() { System.out.println("New ChildB created."); }
}