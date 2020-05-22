public class CustomQueueFullPolicy extends DefaultAsyncQueueFullPolicy {
    public CustomQueueFullPolicy() {
    }

    @Override
    public EventRoute getRoute(final long backgroundThreadId, final Level level) {
        if (backgroundThreadId > 100) {
            return EventRoute.DISCARD;
        }
        return super.getRoute(backgroundThreadId, level);
    }
}