private static Method test;
static {
    try {
        test = ReflectionTest.class.getMethod("testMethod");
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (SecurityException e) {
        e.printStackTrace();
    }
}