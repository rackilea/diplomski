Logger rootLogger = Logger.getLogger(""); 
logHandler = new FileHandler(config.getLogFile(), 
                             config.getLogRotateSize()*1024*1024, 
                             config.getLogRotateCount(), false); 
logHandler.setFormatter(new SimpleFormatter()); 
logHandler.setLevel(Level.INFO); 
rootLogger.removeHandler(rootLogger.getHandlers()[0]); 
rootLogger.setLevel(Level.INFO); 
rootLogger.addHandler(logHandler);