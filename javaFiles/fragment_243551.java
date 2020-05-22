import org.apache.log4j.Logger;

public class LogTest {
    public static void main(final String... args) {
        System.setProperty("logfile.name", "logall.txt");
        System.setProperty("logfilemain.name", "logmain.txt");
        Logger logger = Logger.getLogger(LogTest.class.getName());
        logger.info("hello");
    }
}