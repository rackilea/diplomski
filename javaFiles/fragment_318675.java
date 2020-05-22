timer.scheduleAtFixedRate(new TimerTask() 
    {
        public void run() 
        {
              runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                      images();
                    }
                }); 

        }
    }, delay, period);