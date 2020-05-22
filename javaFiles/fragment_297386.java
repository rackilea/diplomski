class AndroidWay extends Activity { 
TextView name; 
ImageView thumbnail; 
LocationManager loc; 
Drawable icon; 
String myName; 

public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.main);
    name      = (TextView) findViewById(R.id.name); 
    thumbnail = (ImageView) findViewById(R.id.thumbnail); 
    loc       = (LocationManager) getSystemService(Activity.LOCATION_SERVICE); 
    icon      = getResources().getDrawable(R.drawable.icon); 
    myName    = getString(R.string.app_name); 
    name.setText( "Hello, " + myName ); 
}}