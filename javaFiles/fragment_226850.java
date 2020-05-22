public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        // You can call MainActivity to do some actions
        Intent intent = new Intent(MainActivity1.INTENT_FILTER);

        intent.putExtra(MainActivity1.INTENT_BUNDLE_VALUE, "Any string or any value");

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}