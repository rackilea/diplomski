import static org.junit.Assert.*;

public class ValidateTestCase {

    @Test
    public void testHappyPath() throws Exception {
        Validate.stateNotNull("", "");
    }

    @Test
    public void testNullMessage() throws Exception {
        try {
            Validate.stateNotNull(null, null);
            fail();
        }
        catch (IllegalStateException e) {
            String expected = "Exception message is a null object!"
            assertEquals(expected, e.getMessage());
        }
    }

    @Test(expected=IllegalStateException.class)
    public void testNullObject() throws Exception {
        Validate.stateNotNull(null, "test");
    }
}