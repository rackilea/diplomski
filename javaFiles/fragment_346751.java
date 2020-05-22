LinearLayout ll;
 EditText editText;
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.namenpersonenxml);
 ll = (LinearLayout) findViewById(R.id.linearlayout);
 Intent intent = getIntent();
 int aantal = Integer.parseInt(intent.getStringExtra("aantal"));
 for(int i=0;i<aantal;i++)
 {
    editText = new EditText(this);
    editText.setHint("Geef een naam in");
    ll.addView(editText);
 }