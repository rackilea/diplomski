pauseBall()
{
   isPaused=true;
   Timer  t= new Timer();
   t.schedule(new TimerTask() {

     @Override
     public void run() {
            isPaused = false;
     }
   }, fewSeconds);
}