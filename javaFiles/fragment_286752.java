LoggerFactory loggerFactory = new SLF4JLogger.SLF4JLoggerFactory();
LoggingModule loggingModule = new NullDelegatingLoggingModule(loggerFactory);

BlobStoreContext ctx = ContextBuilder.newBuilder("provider")
        .modules(ImmutableSet.of(loggingModule))
        (...)
        .buildView(BlobStoreContext.class);