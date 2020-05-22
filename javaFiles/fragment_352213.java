public class LoggingService implements ILoggingService{

   //other methods here.

   @Override
   public void warn(final Object aMessage, final Object aSender, final Throwable aThrowable) {
       log(aMessage, aSender, Level.WARN, aThrowable);
   }


   private void log(final Object aMessage, final Object aSender, final Level aLevel, final Throwable aThrowable) {
       final String className = getClassNameBy(aSender);
       Logger.getLogger(className).log(className, aLevel, aMessage, aThrowable);
   }
}

public class LoggingController implement ILoggingController{
    //logging service is injected previously
    @Override
    public void warn(final Object aMessage, final Throwable aThrowable) {
        loggingService.warn(aMessage, this, aThrowable);
    }
}