public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);

   Bundle extras = getIntent().getExtras();

   String asd = extras.getString("artist");
   TextView textview = new TextView(this);
   textview.setText("Hello " + asd + " World!");
   setContentView(textview);
}