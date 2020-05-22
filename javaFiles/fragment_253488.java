Timer timer = new Timer();
 timer.schedule( new TimerTask(){
       public void run() {
            synchronized( lock ) { 
                isOpen = false;
            }
        }
   }, 10000 );