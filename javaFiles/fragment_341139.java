private <T> T getLogger(final String loggerName, final Class<T> loggerClass) {
    final org.slf4j.Logger logger = LoggerFactory.getLogger(loggerName);
    try {
        final Class<? extends org.slf4j.Logger> loggerIntrospected = logger.getClass();
        final Field fields[] = loggerIntrospected.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            final String fieldName = fields[i].getName();
            if (fieldName.equals("logger")) {
                fields[i].setAccessible(true);
                return loggerClass.cast(fields[i].get(logger));
            }
        }
    } catch (final Exception e) {
        logger.error(e.getMessage());
    }
    return null;
}