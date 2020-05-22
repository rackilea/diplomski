public class A {
    private static final List<A> instances = new ArrayList<>();

    public A() {
        instances.add(this);
    }

    public static List<A> getInstances() {
        return instances;
    }
}