long time=1000;

  new Timer().scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable(){
                 timeText.setText(String.valueOf(time))
                 time--;
            });
        }
    },1000,0).start();