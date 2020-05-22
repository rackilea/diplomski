TextView tv1;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
tv1 = (TextView) findViewById(R.id.TextView1); 
// initialize after settting layout to activtiy
tv1.setText("New text");
// the above statement must be within a method 
}