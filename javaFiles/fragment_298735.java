@Override 
public void onCreate(Bundle bundle) 
{ 

    super.onCreate(bundle); 
    setContentView(R.layout.pantalla); 
    Bundle extras = getIntent().getExtras(); 
    if (extras == null) 
    { 
        return; 
    } 
    int res = extras.getInt("resourseInt"); 

    ImageView view = (ImageView) findViewById(R.id.something); 

    view.setImageResourse(res); 
}

     Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");