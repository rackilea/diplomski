Logger logger = Logger.getLogger("MyLog");
    FileHandler fh = new FileHandler("C:\\Temp\\Dice_Roll_J\\Logs.txt", true);
    logger.addHandler(fh);
    logger.setLevel(Level.ALL);
    SimpleFormatter formatter = new SimpleFormatter();
    fh.setFormatter(formatter);