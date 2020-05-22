public <T> T castTo(Class<T> t, Object o) {
    return t.cast(o);
}

public <T> T castTo(T t, Object o) {
    return (T) castTo(t.getClass(), o);
}

public void test() {
    String s = "Hello";
    Object b = s;
    String c = castTo(String.class, b);
    String d = castTo("Some String", b);
}