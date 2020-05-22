protected void onCreate(Bundle savedInstanceState) {
    super.onCreate();
    setContentView(//Set your content view);

    final ListView mylist = (ListView) findViewById(R.id.listView1);  

    ArrayList<String> produtcs = getIntent().getStringArrayListExtra("products");


    final ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, produtcs);  


    mylist.setAdapter(adapter);
}