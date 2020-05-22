// Clear previous logging configurations.
LogManager.getLogManager().reset();

// Get the logger for "org.jnativehook" and set the level to off.
Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
logger.setLevel(Level.OFF);