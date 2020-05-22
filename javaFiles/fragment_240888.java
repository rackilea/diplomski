import junit.framework.JUnit4TestAdapter;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

@RunWith(AllTests.class)
public class TestRunner {
    public static TestSuite suite() {
        TestSuite ts = new TestSuite();

        ts.addTest(TestMaker.foo());

        return ts;
    }
}