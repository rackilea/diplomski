class RoboWay extends RoboActivity { 
@InjectView(R.id.name)             TextView name; 
@InjectView(R.id.thumbnail)        ImageView thumbnail; 
@InjectResource(R.drawable.icon)   Drawable icon; 
@InjectResource(R.string.app_name) String myName; 
@Inject                            LocationManager loc; 

public void onCreate(Bundle savedInstanceState) { 
    super.onCreate(savedInstanceState); 
    setContentView(R.layout.main);
    name.setText( "Hello, " + myName ); 
} }