Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    //Executed after YOUR_DELAY_IN_MILLIS
    playingTime()
  }
}, YOUR_DELAY_IN_MILLIS);