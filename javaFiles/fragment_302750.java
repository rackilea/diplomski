public class MainActivity extends AppCompatActivity {
    // Set to true to fix the problem; false will cause the IllegalStateException
    private boolean mFixIt = false;

    private MainFragment mFragment;
    private TextView mTextView;
    private boolean mIsPaused;
    private boolean mUpdateViewNeeded;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mTextView = findViewById(R.id.textView);

        FragmentManager fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            // Create out fragment
            mFragment = MainFragment.newInstance();
            fm.beginTransaction()
                .replace(R.id.container, mFragment)
                .addToBackStack(FRAGMENT_TAG)
                .commit();
        } else {
            // Find the restored fragment.
            mFragment = (MainFragment) fm.findFragmentByTag(FRAGMENT_TAG);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Simulate a background task that does something useful. This one just waits a few
        // second then does a callback to updateView(). The activity will be fully paused by then.
        mFragment.doSomethingInBackground();
        mIsPaused = true;
        Log.d("MainActivity","<<<< stopped");
    }

    @Override
    protected void onStart() {
        super.onStart();
        mIsPaused = false;
        if (mUpdateViewNeeded) {
            // Execute delayed processing now that the activity is resumed.
            updateView(getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG));
        }
    }

    public void updateView(Fragment fragment) {
        if (mIsPaused && mFixIt) {
            // Delay processing
            mUpdateViewNeeded = true;
        } else {
            // Do out update work. If we are paused, this will get an IllegalStateException. If
            // we are resumed, this will work as intended.
            mTextView.setText("Replaced...");
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mUpdateViewNeeded = false;
        }
    }

    public static final String FRAGMENT_TAG = "MyFragment";
}