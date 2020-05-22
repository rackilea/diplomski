Logger logger = Logger.getLogger("logfile.txt");
logger.setUseParentHandlers(false);

ConsoleHandler handler = new ConsoleHandler();

Formatter formatter = new LogFormatter();
handler.setFormatter(formatter);        

logger.addHandler(handler);