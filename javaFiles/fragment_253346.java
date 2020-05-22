int loops;

this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){

          public void run() {
              loops++;//add one to the loops
          }
        },1, 1);