button.setOnClickListener(new OnClickListener() {
    private boolean running = false;
    private CountDownTimer timer;
    @Override
    public void onClick(View v) {
      if(!running)
      {
        running = true;
        timer = new CountDownTimer(4000, 1000) {

            @Override
            public void onFinish() {
                button.setText("SENT");                 
            }

            @Override
            public void onTick(long sec) {
                button.setText("CANCEL (" + sec / 1000 + ")");

            }
        }.start();
      }
      else
      {
         timer.cancel();
         button.setText("Press Me");
         running = false;
      }
    }
});