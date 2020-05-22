public class Test extends TestCase{

    static String stuff;

    public void testCreate(){
        stuff = "abc";
    }

    public void testRead(){
        assertEquals(stuff, "abc");
    }
}