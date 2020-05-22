public class time implements Runnable{
   private Thread counter;
   //making your local varibles members so that they could be used by      "counter" thread
   private long different, secondsInMilli,  minutesInMilli, 
        hoursInMilli, daysInMilli;

   public void printDifference( Date endDate){
        Date now = new Date();
        Date startDate = now;
        //milliseconds
        this.different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : "+ endDate);
        System.out.println("different : " + different);

        //Initializing your variables
        this.secondsInMilli = 1000;
        this.minutesInMilli = secondsInMilli * 60;
        this.hoursInMilli = minutesInMilli * 60;
        this.daysInMilli = hoursInMilli * 24;
        this.counter = new Thread(this, "counter");
        counter.start();
  }

  @Override
  public void run() {
      if(Thread.currentThread().getName().equals("counter")){
          try{
              long differentCopy = different;
                  while(differentCopy > 0 ){
                      //dropping your calculations here
                      long elapsedDays = different / daysInMilli;
                      different = different % daysInMilli;

                      long elapsedHours = different / hoursInMilli;
                      different = different % hoursInMilli;

                      long elapsedMinutes = different / minutesInMilli;
                      different = different % minutesInMilli;

                      long elapsedSeconds = different / secondsInMilli;
                      System.out.printf("%d days, %d hours, %d minutes, %d seconds\n",
                            elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
                      different = differentCopy-=1000;
                      Thread.sleep(1000);
                  }
          }catch(InterruptedException | HeadlessException e){
            e.printStackTrace();
          }
      }
  }
  public static void main(String[] args) {
    // TODO code application logic here
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.MILLISECOND, 10000);//current time + 10s
    Date endDate = calendar.getTime();
    time t = new time();
    t.printDifference(endDate);
}}