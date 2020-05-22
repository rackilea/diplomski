import org.apache.log4j.*;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

class ExecutionListener extends RunListener {

    private final Logger logger;

    /**
    * Constructor for class ExecutionListener.
    */
    public ExecutionListener() {
        logger = LogManager.getLogger(GenericTaskInterpreterTests.class);
        FileAppender fileAppender = new FileAppender();
        fileAppender.setName("FileLogger");
        fileAppender.setFile("path/to/log4j-application.log");
        fileAppender.setLayout(new PatternLayout("%d %-5p [%c{1}.%M] %m%n"));
        fileAppender.setThreshold(Level.DEBUG);
        fileAppender.setAppend(true);
        fileAppender.activateOptions();

        LogManager.getRootLogger().addAppender(fileAppender);
    }

    /**
    * Called when all tests have finished
    */
    public void testRunFinished(Result result) throws Exception {
        logger.info("Number of testcases executed : " + result.getRunCount());
        logger.info("Number of testcases failed : " + result.getFailureCount());
        logger.info("☺"); // This gets written to the log file
        logger.info(String.valueOf(Character.toChars(0x263A))); // Same thing as above, smiley face gets written to log file.
    }
}