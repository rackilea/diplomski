public class CallMethod implements Runnable
{
   //time in milli
   public long getStartTime()
   {
     return startTime;
   }

   //time in milli
   public long getEndTime()
   {
     return endTime;
   }

   public void run()
   {
       startTime = ...;
       obj.longRunningMethod();
       endTime = ...;
   }
}