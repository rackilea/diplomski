int loops;

this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

          public void run() {
              loops++;//add one to the loops

                      if(loops %  5 == 0){//if loops is divisible by 5
                          //fly check code
                      }
                      if(loops % 7 == 0){//if loops is divisible by 7
                          //withdraw code
                      }
          }
        },1, 1); //make the timer repeat every 1 tick