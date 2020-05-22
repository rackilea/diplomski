final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
    Log.d("Log:", "Hello!");
    handler.postDelayed(this, 1000);
  }
}, 1000);