public class A {
    private static List<A> createdAs = new ArrayList<>();

    public A() {
        synchronized(createdAs) {
            createdAs.add(this);
        }
    }
}