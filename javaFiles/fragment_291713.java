public class MyActivity extends Activity {

    private Handler mHandler = new Handler();

    public class BroadcastReceiver mReceiver = new BroadcastReceiver() {

        public void onReceive (Context context, Intent intent) {
            // ... use mHandler in here ....
            mHandler.postDelayed(runnable, 1000);
        }

    }

    // ... rest of the code ...

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

}