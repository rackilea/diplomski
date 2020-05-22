import junit.framework.TestCase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({First.class,Second.class,Third.class})
public class RunTestSuite extends TestCase {
    @BeforeClass
    public static void doYourOneTimeSetup() {
        ...
    }

    @AfterClass
    public static void doYourOneTimeTeardown() {
        ...
    }    
}