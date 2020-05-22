private static class InvalidPropertyEventListener implements EventListener {

    /**
     * Continues processing even if an <code>invalidProperty</code> runtimeException was thrown
     * during FO to PDF transformation.
     * <p>
     * Descends the event's severity level to WARN to avoid the exception throwing.
     *
     * @param event The event to be processed.
     */
    public void processEvent(Event event) {
        if ("org.apache.fop.fo.FOValidationEventProducer.invalidProperty".equals(event.getEventID())) {
            event.setSeverity(EventSeverity.WARN);
        }
    }
}