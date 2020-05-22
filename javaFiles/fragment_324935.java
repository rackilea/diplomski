// Getting JUL root logger
Logger logger = java.util.logging.LogManager.getLogManager().getLogger("");

// Remove already attached Console handler which is responsible for above trouble
for (Handler handler : logger.getHandlers()) {
    handler.close();
    logger.removeHandler(handler);
}

// Let SLF4J bridge configure its own handler(s)
SLF4JBridgeHandler.install();