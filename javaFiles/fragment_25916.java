private Timer executeTimer;
 TimerContext timerContext;
 obj.timerContext = obj.executeTimer.time();
 .
 .
 .
 public void f()
   {
       timerContext = executeTimer.time();//start timer
       f2();
       timerContext.stop();//stop timer
       //All stats are sent to JMX port by default. You can open console to view them
   }