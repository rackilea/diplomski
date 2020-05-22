EditText nameTextBox;
EditText timeTextBox;
EditText detailsTextBox;
Button createButton ;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.create);
createButton = (Button)findViewById(R.id.apptSave);
nameTextBox = (EditText)findViewById(R.id.apptName);
timeTextBox = (EditText)findViewById(R.id.apptTime);
detailsTextBox = (EditText)findViewById(R.id.apptDetails);
calendar= (CalendarView)findViewById(R.id.calendar);