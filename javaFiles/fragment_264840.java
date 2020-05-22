public class FooTest
{
    @Test
    void verifyCallToSuperConstructor()
    {
        new MockUp<Bar>() {
            @Mock(invocations = 1) // verifies one call will occur
            void $init(int x, int y)
            {
                assertEquals(0, y);
            }
        };

        new Foo(123);
    }
}