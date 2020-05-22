public void logEvent(EventType type, Event message) {
        EventLogger eventLogger;
        if (type == null) eventLogger = defaultLogger;
        else eventLogger = loggers.get(type);
        eventLogger.logEvent(message);
    }