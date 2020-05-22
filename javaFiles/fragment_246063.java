long minute = 1000*60;

Timer timer1 = new Timer();
long delay1 = 45*minute;
Timer timer2 = new Timer();
long delay2 = 15*minute;
TimerTask tt1;
TimerTask tt2;

...

tt1 = new TimerTask()
{
   public void run()
   {
      //do something and:
      timer2.schedule(tt2, delay2);
   }
};

tt2 = new TimerTask()
{
   public void run()
   {
      //do something and:
      timer1.schedule(tt1, delay1);
   }
};

timer1.schedule(tt1, delay1);