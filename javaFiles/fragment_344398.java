public class MyActivity extends Activity {
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler.postDelayed(new Runnable() {
            public void run() {
                doStuff();
            }
        }, 5000);
    }

    private void doStuff() {
        Toast.makeText(this, "Delayed Toast!", Toast.LENGTH_SHORT).show();
    }
}