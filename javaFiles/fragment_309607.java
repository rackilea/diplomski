int count = 0; //Declare as instance variable    
Activity activity; //Declare as instance variable 

//Inside onCreate()
activity = this;
    new Timer().schedule(new TimerTask() {

        @Override
        public void run() {

            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (count < 10000) {
                        if (count % 2 != 0) {
                            helpt.setBackgroundColor(getResources()
                                    .getColor(android.R.color.black));
                        } else {
                            helpt.setBackgroundColor(getResources()
                                    .getColor(android.R.color.white));
                        }
                        count = count + 1;
                    }
                }
            });

        }
    }, 0, 1000);