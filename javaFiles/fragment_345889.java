if(logger.getHandlers().length == 0){
    System.out.println("Adding a new handler"); 
    consoleHandler = new ConsoleHandler();
    logger.addHandler(consoleHandler);
}               

logger.getHandlers()[0].setLevel(Level.INFO);
logger.severe("test severe logging " + logger.getName());
logger.warning("test warning logging " + logger.getName());
logger.info("test info logging " + logger.getName());
logger.finer("test finer logging " + logger.getName());
logger.finest("test finest logging " + logger.getName());