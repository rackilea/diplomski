@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
Bundle extras = getIntent().getExtras();
if (extras != null) {
 String datas= extras.getString("EXTRA_ID");
 if (datas!= null) {
    // do stuff
 }        
 }