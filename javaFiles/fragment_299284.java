public /*static*/ class MyAppender extends AppenderSkeleton {
    ArrayList<LoggingEvent> eventsList = new ArrayList();

    @Override
    protected void append(LoggingEvent event) {
        eventsList.add(event);
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }

}