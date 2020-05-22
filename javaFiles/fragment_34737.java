protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Intent myIntent = getIntent();
    String arg1 = myIntent.getStringExtra("para1");
    String arg2 = myIntent.getStringExtra("para2");
    String arg3 = myIntent.getStringExtra("para3");
    String arg4 = myIntent.getStringExtra("para4");
    // here you have to check that they or not null to differentiate 
    // if it is a new Note to be created OR you have to edit.
    // you should probably use some another way to figure this out, i am writing this because i would not be using it :)

}