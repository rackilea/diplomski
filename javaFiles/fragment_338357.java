Timer t = new Timer();
t.scheduleAtFixedRate(new TimerTask() {
   @Override
   public void run() {
      if ( wasTouched == false ) {
         runOnUiThread(new Runnable() {
             public void run(){
               hideYourActionBar();
             }      
          });
      } else {
        wasTouched = false;
      }
   }    
 }, 0, YourDelayInMsHere);