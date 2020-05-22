import junit.framework.TestCase;
public class JunitTestCases extends TestCase {
    public JunitTestCases(String fnName) {
        super(fnName);
    }
    public void testA() {
        assertTrue("assertTrue failed", true);
    }
}