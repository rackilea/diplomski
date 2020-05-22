public class FooTest {

    private final Context context = mock(Context.class);

    @Rule
    public MockInitialContextRule mockInitialContextRule = new MockInitialContextRule(context);

    @Test
    public void testName() throws Exception {
        // set up stubbings on the context mock
        // invoke the code under test
    }
}