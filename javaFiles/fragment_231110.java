Timer timer = new Timer();
timer.schedule(new TimerTask() {      
    @Override
    public void run() {
       runOnUiThread(new Runnable(){
       @Override
       public void run(){
        TextView txtClicks = (TextView) findViewById(R.id.txtClicks);
        // task to be done every 1000 milliseconds
        iClicks = iClicks + 1;
        txtClicks.setText(String.valueOf(iClicks));
        }
  });

    }
}, 0, 1000);