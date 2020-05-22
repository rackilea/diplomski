final Handler handler = new Handler();
Timer time = new Timer(); // Instantiate Timer Object
time.schedule(new TimerTask(){
    public void run() {
            handler.post(new Runnable(){
            // i call my Asyntasks here
             });
   }
},5000,5000);