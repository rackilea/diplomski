import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({ A.class,B.class, 
        C.class })
public class SampleTesterSequence {
    @BeforeClass
    public static void beforeStories() throws Exception {
       //TODO Implement before story steps
    }

    @AfterClass
    public static void afterStories() throws Exception {
      //TODO Implement after story steps
    }
}