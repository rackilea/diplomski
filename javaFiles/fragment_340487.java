class Foo {
    private static Set<String> state = new HashSet<>();
    public static synchronized void bar(String item) {
        state.add(item);
    }
    public /* synchronized */ baz(String item) {
        synchronized (Foo.class) {
            state.add(item);
        }
    }
}