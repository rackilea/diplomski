Logger logger = Logger.getLogger("myLogger");
logger.addAppender(new ConsoleAppender(new SimpleLayout()));

System.out.println("*** The current level will be INFO");

logger.setLevel(Level.INFO);
logger.warn("Only INFO and higher will appear");
logger.info("Only INFO and higher will appear");
logger.debug("Only INFO and higher will appear");

System.out.println("*** Changing level to DEBUG");

// remember the previous level
Level previousLevel = logger.getLevel();

logger.setLevel(Level.DEBUG);
logger.warn("DEBUG and higher will appear");
logger.info("DEBUG and higher will appear");
logger.debug("DEBUG and higher will appear");

System.out.println("*** Changing level back to previous level");

// revert to previous level
logger.setLevel(previousLevel);
logger.warn("Only INFO and higher will appear");
logger.info("Only INFO and higher will appear");
logger.debug("Only INFO and higher will appear");