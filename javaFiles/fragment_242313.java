public class MyRunnable implements Runnable
{
   public boolean killMe = false;

   public void run()
   {
      if(killMe)
         return;

      /* do your work */
   }

   public void killRunnable()
   {
      killMe = true;
   }
}