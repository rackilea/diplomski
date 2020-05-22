@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
String test = "test";
TextView text = (TextView) findViewById(R.id.textView);
text.setText(test);


}