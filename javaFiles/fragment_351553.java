public class HandlerTest {
    @Test
    public void testRun() {
        StringBuilder str = new StringBuilder("1234");
        Handler.run(str);
        Assert.assertEquals("34", str.toString());
    }
}