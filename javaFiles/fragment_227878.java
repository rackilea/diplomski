private class JSCHLogger implements com.jcraft.jsch.Logger {
    private Map<Integer, MyLevel> levels = new HashMap<Integer, MyLevel>();

    private final MyLogger LOGGER;


    public JSCHLogger() {
        // Mapping between JSch levels and our own levels
        levels.put(DEBUG, MyLevel.FINE);
        levels.put(INFO, MyLevel.INFO);
        levels.put(WARN, MyLevel.WARNING);
        levels.put(ERROR, MyLevel.SEVERE);
        levels.put(FATAL, MyLevel.SEVERE);

        LOGGER = MyLogger.getLogger(...); // Anything you want here, depending on your logging framework
    }

    @Override
    public boolean isEnabled(int pLevel) {
        return true; // here, all levels enabled 
    }

    @Override
    public void log(int pLevel, String pMessage) {
        MyLevel level = levels.get(pLevel);
        if (level == null) {
            level = MyLevel.SEVERE;
        }
        LOGGER.log(level, pMessage); // logging-framework dependent...
    }
}