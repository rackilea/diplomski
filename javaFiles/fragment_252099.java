public class AwesomeService extends Service {
// other stuff
  private int DELAY = 2000;
  Handler mHandler = new Handler();
  Runnable toastRunnable;
  public void doToast() {
    mHandler.postDelayed(getToastRunnable(), DELAY);
  }
  private Runnable getToastRunnable() {
    Runnable r = new Runnable() { 
      @Override public void run() {
        // show toast
        // doToast()
      }
    };
    toastRunnable = r;
    return r;
  }
...
  // and to remove the callbacks,
  @Override public void onDestroy() {
    super.onDestroy();
    mHandler.removeCallbacks(toastRunnable);
  }
}