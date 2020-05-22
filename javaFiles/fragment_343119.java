public static Foobar requestToken() {
    // ...
}

@Test
public void someTestMethod() {
    Foobar x = TestClass.requestToken();

    // work with 'x'
}

@Test
public void someOtherTestMethod() {
    Foobar x = TestClass.requestToken();

    // do other test with 'x'
}