public class SubCategory extends AppCompatActivity {

    private ListView listView;
    String buttonType;
    ArrayAdapter adapter;

    static final String[] FRUITS = new String[] { "Apple", "Avocado", "Banana"};
    static final String[] NAMES = new String[] { "Sachin", "Brett", "Shane", "Zaheer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);



        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            buttonType = bundle.getString("BUTTON_CLICKED");
        }
        if(buttonType != null && buttonType.equals("A")) {
            adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, FRUITS);
        } else if(buttonType != null && buttonType.equals("B")) {
            adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, NAMES);
        }
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);
    }
}