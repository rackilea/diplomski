public class MainActivity extends ActionBarActivity {
    private String numString = "";
    private ArrayList<String> keyArrayList;
    EditText editTextView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextView = (EditText)findViewById(R.id.textView);

        keyArrayList = new ArrayList<String>(); //added
    }