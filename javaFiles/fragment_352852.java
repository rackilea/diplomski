@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_results);
String extra = getIntent().getStringExtra("extraname") //returns null if nothing
Double extra2 = getIntent().getDoubleExtra("extraname2")