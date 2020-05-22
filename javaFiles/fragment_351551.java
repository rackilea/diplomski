public class HandlerTest {
    @Test
    public void testRun() {
        StringBuilder str = new StringBuilder("1234");
        Handler handler = Mockito.mock(Handler.class);
        when(handler.run(any(StringBuilder.class))).thenCallRealMethod();
        handler.run(str);
        Assert.assertEquals("34", str.toString());//add toString here, because you are comparing a String to a StringBuilder
    }
}