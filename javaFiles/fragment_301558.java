private static final java.util.logging.Logger[] pin;
static {
    //Pin first.
    pin = new java.util.logging.Logger[] { 
        java.util.logging.Logger.getLogger(""),
        java.util.logging.Logger.getLogger("3rd.party.package") };

    //Setup SLF4J
    LogManager.getLogManager().reset();
    SLF4JBridgeHandler.removeHandlersForRootLogger();
    //SLF4JBridgeHandler.install();
    java.util.logging.Logger.getLogger("").addHandler(new SLF4JBridgeHandler());

    //Change JUL levels.
    for (java.util.logging.Logger l : pin) {
        l.setLevel(Level.FINEST);
    }
}