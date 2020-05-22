// Jersey uses java.util.logging - bridge to slf4
java.util.logging.Logger rootLogger = LogManager.getLogManager().getLogger("");
Handler[] handlers = rootLogger.getHandlers();
for (int i = 0; i < handlers.length; i++) {
    rootLogger.removeHandler(handlers[i]);
}
SLF4JBridgeHandler.install();