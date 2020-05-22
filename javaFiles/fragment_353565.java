public final class FetchMail extends TimerTask {
        static Timer timer=null;
      public static void main (String[] args) 
      {
        System.out.println("starting");
        TimerTask fetchMail = new FetchMail();
         timer= new Timer();
        timer.schedule(fetchMail, 3000);

        //timer.cancel();
        System.out.println("exiting");
      }

      public void run()
      {
        System.out.println("Fetching mail...");
        timer.cancel();
      }


    }