public class FsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        SPAdapter sa = new SPAdapter(getApplicationContext());
        sa.prefGet("", "");
    }
}