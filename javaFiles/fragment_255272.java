public class MyClassTest {
    // The class under test
    // Initialized here instead of in a @Before method for brevity
    private MyClass underTest = new MyClass();

    // Not really needed, just makes things more explicit
    @Rule
    public ExpectedException noExceptionAllowed = ExpectedException.none();

    @Test
    public void testSomeMethod() throws SomeException {
        // If an exception is thrown, the test errors out, and doesn't pass
        myClass.someMethod();
    }
}