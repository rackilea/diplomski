public void execute(ContextObject context) {
    if (logger.debuggingEnabled()) {
        String invokingClassName = ""; // <-- how do I get this?
        logger.debug("Executing {}", this.getClass().getName());
    }
    // shared application logic is here...
}