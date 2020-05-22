class EventLogHandler {
    private final Marker eventMarker = MarkerFactory.getMarker("EVENT");
    private final Logger logger;

    public EventLogHandler() {
        this(LoggerFactory.getLogger(EventLogHandler.class));
    }

    // probably only used by your test case
    public EventLogHandler(Logger logger) {
        this.logger = logger;
    }

    public void handle(final Event event) {
        logger.info(eventMarker, log);
    }
}