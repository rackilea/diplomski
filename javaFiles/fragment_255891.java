@Test
public void testStaticMethodWhenSomethingUnexpectedHappens() throws Exception {
    mockStatic(StaticClass.class);
    // changed exception type
    doThrow(new IllegalStateException("unimportant message")).when(StaticClass.class, "staticMethod");

    SomeClass instance = new SomeClass();
    try {
        instance.someMethod();
        fail("IllegalStateException expected");
    } catch (IllegalStateException expected) {
    }

    // added verification
    verifyStaticMethodWasInvokedOneTime();
}

@Test
public void testStaticMethodHappyPath() throws Exception {
    mockStatic(StaticClass.class);
    doNothing().when(StaticClass.class, "staticMethod");

    SomeClass instance = new SomeClass();
    instance.someMethod();

    // added verification
    verifyStaticMethodWasInvokedOneTime();
}

private void verifyStaticMethodWasInvokedOneTime() throws SomeException {
    verifyStatic(StaticClass.class);
    StaticClass.staticMethod();
}