import junit.framework.TestCase; 

public class DummyTestA extends TestCase {
    public void testSum() {
        int a = 5;
        int b = 10;
        int result = a + b;
        assertEquals(15, result);
    } 
}