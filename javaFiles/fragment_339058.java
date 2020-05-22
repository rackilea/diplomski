import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.clarkware.junitperf.TestFactory;

class JUnit4TestFactory extends TestFactory {

    static class DummyTestCase extends TestCase {
        public void test() {
        }
    }

    private Class<?> junit4TestClass;

    public JUnit4TestFactory(Class<?> testClass) {
        super(DummyTestCase.class);
        this.junit4TestClass = testClass;
    }

    @Override
    protected TestSuite makeTestSuite() {
        JUnit4TestAdapter unit4TestAdapter = new JUnit4TestAdapter(this.junit4TestClass);
        TestSuite testSuite = new TestSuite("JUnit4TestFactory");
        testSuite.addTest(unit4TestAdapter);
        return testSuite;
    }

}