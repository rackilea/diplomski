Thread th = new Thread(){
        public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        health_bars(new_health_one, new_health_two);
                    }
                });
       }
      }