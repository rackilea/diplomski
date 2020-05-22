private Handler handler = new Handler();

private void startCounting() {
    handler.post(run);
}

private Runnable run = new Runnable() {
  @Override
  public void run() {
    number++;
    tvFragment.setText(number);
    handler.postDelayed(this, 1000);
  }
};