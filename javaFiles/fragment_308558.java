@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    List<MyObjectClass> list = new ArrayList<MyObjectClass>();
    for(int i=0; i < 3; i++){
        list.add(new MyObjectClass(QUNTITY,GET_ID,GET_BRAND,GET_CATEGORY,GET_DESCRIPTION,GET_CODE,GET_PRICE));
    }
    ListView lv = (ListView) findViewById(R.id.listView);
    CustomAdapter adapter = new CustomAdapter(this,list);
    lv.setAdapter(adapter);

 }