public class FooTest{

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    // Default constructor is used to create a real Foo instance.
    // In the test's body, though, we'll override the behavior of SOME of the methods
    @Spy
    Foo fooInstance;

    @Test
    public void xTest {
        doReturn(true).when(fooInstance).y(/* arguments, presumably 25 */);
        Boolean result = fooInstance.x(25);
        Assert.assertTrue(result);
    }
}