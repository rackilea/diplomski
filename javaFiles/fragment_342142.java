ListView listView;
public String tag_name;
public List<NameAddress> nameAddressList;
Context context;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_of_places);

    context = YourActivityName.this;

    listView = (ListView) findViewById(R.id.list_of_places);

    Intent intent = getIntent();
    if (intent != null) {
        tag_name = intent.getStringExtra("CategoryName");
        new ListAsync().execute();
    }
}