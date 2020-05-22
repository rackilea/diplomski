public static boolean check(Class<?> cls) {
    try {
        Method method = ObjectStreamClass.class.getDeclaredMethod("hasStaticInitializer", Class.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, cls);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
    }
    // trivial
    throw new RuntimeException();
}

static class Test { static { } }
static class Test2 { }

public static void main(String[] args) {
    assert check(Test.class);
    assert !check(Test2.class);
}