public class LoggingExceptionResolver extends SimpleMappingExceptionResolver {
private Logger logger = LoggerFactory.getLogger(LoggingExceptionResolver.class);

@Override
protected void logException(Exception ex, HttpServletRequest request) {
    this.logger.warn(buildLogMessage(ex, request), ex);
}