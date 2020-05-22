Thread timer=new Thread(){
        @Override
        public void run(){
          Log.i("Thread","Running"); 
          // you should see the log message if the thread runs
            try {

                    // do othere operations
                runOnUiThread(new Runnable() {
                        @Override 
                    public void run() {
                        // dispaly toast here;
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    timer.start();