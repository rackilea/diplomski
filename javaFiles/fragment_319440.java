public class Test
{

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @org.junit.Test
    public void throwsIllegalArgumentExceptionIfIconIsNull()
    {
        exception.expect(IllegalArgumentException.class);
        toTest();
    }

    private void toTest()
    {
        throw new IllegalArgumentException();
    }
}