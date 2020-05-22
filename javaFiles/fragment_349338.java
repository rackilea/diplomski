yourTextAreaAppender.addFilter(new Filter() {
    @Override
    public int decide(LoggingEvent event) {
        if (event.getLevel().equals(Level.INFO)) {
            return ACCEPT;
        } else {
            return DENY;
        }
    }
});