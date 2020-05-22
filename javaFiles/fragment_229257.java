final Runnable mUpdateTimeTasks = new Runnable() {
      public void run() {
           countdowntext.setText(String.valueOf(cd));
           cd -=1;
           if(cd < 10) {
                countdowntext.setTextColor(Color.RED);
           }
           if(cd == 0) { 
                focus.stop();        
                mHandler.removaCallbacks(null);
                return;                   
           }
           mHandler.postDelayed(this, 1000)
};