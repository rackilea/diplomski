Date now = new Date();
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("D_hh_mm");
    String logName = "[baseFilename]" + df.format(now);
    File logFolder = new File(someDirectory, "logs");
    try {
        if(!logFolder.exists())
            logFolder.mkdir();
        File logFile = new File(logFolder,logName+".log");
        Handler logFileHandler = new FileHandler(logFile.getAbsolutePath());
        logFileHandler.setFormatter(new SimpleFormatter());
        globalLog.addHandler(logFileHandler);            
    }
    catch(java.io.IOException ioe) { /* Log file could not be created. */  }
    globalLog.setLevel(Level.INFO);