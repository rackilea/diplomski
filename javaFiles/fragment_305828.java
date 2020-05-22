private int mInterval = 10000; // 10 seconds as you need
private Handler mHandler;

@Override
protected void onCreate(Bundle bundle) {

    // your code here

    mHandler = new Handler();
    startRepeatingTask();
}

@Override
public void onDestroy() {
    super.onDestroy();
    stopRepeatingTask();
}

Runnable mStatusChecker = new Runnable() {
    @Override 
    public void run() {
          try {
               updateStatus(); //this function can change value of mInterval.
          } finally {
               // 100% guarantee that this always happens, even if
               // your update method throws an exception
               mHandler.postDelayed(mStatusChecker, mInterval);
          }
    }
};

void startRepeatingTask() {
    mStatusChecker.run(); 
}

void stopRepeatingTask() {
    mHandler.removeCallbacks(mStatusChecker);
}