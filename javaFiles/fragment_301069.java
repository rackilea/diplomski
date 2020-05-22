//Create a new Handler
Handler fh = new FileHandler("error.log");
fh.setLevel(Level.WARNING);

//Register it with the ROOT logger
Logger.getLogger("").addHandler(fh);

//Log some messages
Logger.getLogger("scratchpad").info("Info !");
Logger.getLogger("scratchpad").warning("Warning !");
Logger.getLogger("scratchpad").severe("Severe !");

//Log some messages via SL4J 
LoggerFactory.getLogger("scratchpad").error("sl4j message");