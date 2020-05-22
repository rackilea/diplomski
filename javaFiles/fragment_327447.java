public abstract class A {
    private static HashSet<Class<?>> classes = new HashSet<Class<?>>();

    public A () {
        synchronized (classes) {
            Class<?> c = this.getClass();
            if (classes.contains(c)) {
                throw NotSingletonException("Class " + c + " is not singleton");
            }
            classes.add(c);
        }
    }
}