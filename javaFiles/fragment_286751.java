static class DelegatingNullLogger extends BaseLogger {
    private final Logger logger;

    public static class DelegatingNullLoggerFactory implements LoggerFactory {
        private final LoggerFactory delegate;

        public DelegatingNullLoggerFactory(LoggerFactory delegate) {
            this.delegate = checkNotNull(delegate, "delegate");
        }

        @Override
        public Logger getLogger(String category) {
            return new DelegatingNullLogger(delegate.getLogger(category));
        }
    }

    public DelegatingNullLogger(Logger logger) {
        this.logger = logger;
    }

    // Implement methods
}

static class NullDelegatingLoggingModule extends LoggingModule {
    private final LoggerFactory loggerFactory;

    public NullDelegatingLoggingModule(LoggerFactory loggerFactory) {
        this.loggerFactory = checkNotNull(loggerFactory, "loggerFactory");
    }

    @Override
    public LoggerFactory createLoggerFactory() {
        return new DelegatingNullLogger.DelegatingNullLoggerFactory(loggerFactory);
    }
}