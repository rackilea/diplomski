private static final Logger LOGGER = Logger.getLogger(MyMainClass.class.getName());

static {
    Logger logger = LOGGER.getParent();
    while(logger != null) {
        Handler[] handlers = logger.getHandlers();
        if(handlers != null) {
            for(Handler handler : handlers) {
                logger.removeHandler(handler);
            }
        }

        if(logger.getParent() == null) {
            logger.addHandler(SystemErrHandler.newInstance());
        }
        else {
            logger.setUseParentHandlers(true);
        }

        if(logger.getName().startsWith("my.sample.package")) {
            logger.setLevel(Level.ALL);
        }
        logger = logger.getParent();
    }
}