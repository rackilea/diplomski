public class LogAndRethrowExceptionHandler implements ExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(...);

    @Override
    public void handleException(RepeatContext repeatContext, Throwable throwable) throws Throwable {
        LOGGER.error(throwable.getMessage());
        throw throwable;
    }
}