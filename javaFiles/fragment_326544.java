TextView t;

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.high_risk);
Intent intent = getIntent();
String text= intent.getStringExtra("TestKey");

t = (TextView) findViewById(R.id.abusedOrNah);
t.setText(text);