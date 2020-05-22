public class WalmartActivity extends Activity {
    /** Called when the activity is first created. */

    EditText name;
    Button search;
    TextView display;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); 

        name = (EditText) findViewById(R.id.etName);
        search = (Button) findViewById(R.id.btnSearch);
        display = (TextView) findViewById(R.id.display);

        ....