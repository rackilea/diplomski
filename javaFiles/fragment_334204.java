public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       this.setContentView(R.layout.single_list_item_view);


    Bundle extras = getIntent().getExtras(); 
    if( extras != null ) {
          String test = extras.getString("TAG_NAME");
          Log.d("", "Value passed = " + test);
     }

    }