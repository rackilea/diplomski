public class Main {
    interface A {}
    class B implements A {}
    class C implements A {}
    private List<Class<? extends A>> classes = new ArrayList<>();
    {
        classes.add(B.class);
        classes.add(C.class);
    }
}