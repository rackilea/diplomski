@PrepareForTest(Simple.class)
public class ProcessorTest extends PowerMockTestCase {
    @Test
    public void doMe() throws Exception {
        Simple spy = PowerMockito.spy(new Simple());
        PowerMockito.doReturn("hello").when(spy, "privateMethod");

        String res = spy.doMe();

        PowerMockito.verifyPrivate(spy, Mockito.times(1)).invoke(
                "privateMethod");
        Assert.assertEquals( res, "hello");
    }
}