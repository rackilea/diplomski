protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_test);

datedisplay1 = (TextView) findViewById(R.id.date_display1);
datedisplay1.setText("Date: ");

buttonBack1 = (Button) findViewById(R.id.buttonBack);
buttonBack1.setOnClickListener(this);
Bundle intent = getIntent().getExtras();
int day = intent.getInt("Date");
int month = intent.getInt("Month");
int year = intent.getInt("Year");
Log.d(TAG, "THIRD LOG : "  + day  + " / " + month + " / " + year);
datedisplay1.setText("Date: " + day  + " / " + month + " / " + year);
}