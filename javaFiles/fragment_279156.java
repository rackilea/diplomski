try {
    MyClass.class.getMethod("multiply", int.class, int.class);
} catch (NoSuchMethodException) {
    // test has failed.
    fail(); //do not swallow this exception, fail the test
}