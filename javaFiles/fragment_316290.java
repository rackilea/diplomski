Logger logger=null;

if(globalLogger!=null){
    logger = Logger.getLogger(globalLogger);
} else{
  logger = Logger.getLogger(ImportThread.class.getName());
}