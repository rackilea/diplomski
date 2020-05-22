public void run() {
  try {
    Thread.sleep(5000);
    startActivity(new Intent(SplashActivity.this, LoginAuthenticationActivity.class));
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
  finish();
}