@Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ...
    Intent i = getIntent();
        if (i.hasExtra("aKey")){
             String value = i.getStringExtra("aKey");   
        }
  }