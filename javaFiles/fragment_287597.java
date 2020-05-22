private List<String> list
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    searchButton = (Button) findViewById(R.id.findButton);
    //searchButton.setOnClickListener(this);
    mainSearchView = (EditText) findViewById(R.id.searchText);
    spinner1 = (Spinner) findViewById(R.id.titleCategory1);
    list = new ArrayList<String>();