public class LogTest {

    public static void main(String[] args) {
        final Logger log = LogManager.getLogger();

        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warning message");
        log.error("This is an error message");
        log.fatal("This is a fatal message");
    }
}