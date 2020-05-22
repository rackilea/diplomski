import junit.framework.*;

public class JunitTestSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new JunitTestCases("testA"));
    return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}