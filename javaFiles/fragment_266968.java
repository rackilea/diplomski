// ArrayList for Listview
ArrayList<HashMap<String, String>> productList;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Listview Data
    String products[] = {"Dell Inspiron", "HTC One X", "HTC Wildfire S", "HTC Sense", "HTC Sensation XE",
                            "iPhone 4S", "Samsung Galaxy Note 800",
                            "Samsung Galaxy S3", "MacBook Air", "Mac Mini", "MacBook Pro"};

    lv = (ListView) findViewById(R.id.list_view);
    inputSearch = (EditText) findViewById(R.id.inputSearch);

    // Adding items to listview
    adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);
    lv.setAdapter(adapter);       

}