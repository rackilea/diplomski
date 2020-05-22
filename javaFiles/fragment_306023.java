public class FileFilter extends Filter<ILoggingEvent> {

   @Override
   public FilterReply decide (ILoggingEvent event) {

      try {
         // I have in a database table something like this:
         //    Level   -   Appender
         //    ERROR         FILE
         //    DEBUG        CONSOLE
         //    ...

         // Here I check with a service if "the actual logger level"
         // [event.getLevel()] in the previous database table, is set
         // to record their messages with the "current appender"

         if (thePreviousCondition == true)
            return FilterReply.ACCEPT;

         return FilterReply.DENY;

      } catch (Exception e) {
         return FilterReply.DENY;
      }
   }
}