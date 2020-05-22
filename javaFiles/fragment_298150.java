import org.apache.log4j.Logger;

public class ClassUnderTest {
    private static Logger logger = Logger.getLogger(ClassUnderTest.class);

    public void run() {
        logger.info("Hello.");
    }
}