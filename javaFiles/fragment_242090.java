public class NextActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set some content if you wish
        Log.d("LOG_TAG", "Passed value: " + getIntent().getParcelableExtra("PASS"));
    }
}