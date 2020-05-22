public class MainActivity extends Activity {

TextView mClock;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mClock = (TextView) findViewById(R.id.your_textview_id);
}

private Handler mHandler = new Handler();
private Runnable timerTask = new Runnable() {
    @Override
    public void run() {
        Calendar now = Calendar.getInstance();
        mClock.setText(String.format("%02d:%02d:%02d",
                now.get(Calendar.HOUR),
                now.get(Calendar.MINUTE),
                now.get(Calendar.SECOND)) );
        mHandler.postDelayed(timerTask,1000);
    }
};

@Override
public void onResume() {
    super.onResume();
    mHandler.post(timerTask);
}

@Override
public void onPause() {
    super.onPause();
    mHandler.removeCallbacks(timerTask);
}
}