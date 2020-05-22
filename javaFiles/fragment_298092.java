@PrepareOnlyThisForTest(Foo.class)
@RunWith(PowerMockRunner.class)
public class FooTest {
    @Test
    public void bar() throws Exception {
        PowerMockito.mockStatic(Foo.class, Mockito.CALLS_REAL_METHODS); // prepare
        ...
    }
}