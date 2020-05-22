public TextView text;

//....


@Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_layout);

   text = (TextView)findViewById(R.id.text);
   //...