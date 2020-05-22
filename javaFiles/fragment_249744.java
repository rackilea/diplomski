static {
    java.util.logging.LogManager.getLogManager().reset();
    java.util.logging.Logger.getLogger("global").setLevel(Level.FINEST);
    SLF4JBridgeHandler.removeHandlersForRootLogger();
    SLF4JBridgeHandler.install();
}