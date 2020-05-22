class DisasterLogger{
      private static final Log logger = Logger.getLogger(DisasterLogger.class); //or any other way you provide the logger
      public void log(String message){
           logger.log(MyLevel.DISASTER, message);
      }
 }