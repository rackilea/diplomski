public class SecondCity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Boolean customTitleSupported = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE); 
        // Set the layout to use
        setContentView(R.layout.main);
        if (customTitleSupported) {
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.custom_title); 
            TextView tv = (TextView) findViewById(R.id.tv); 
            Typeface face=Typeface.createFromAsset(getAssets(),"BFantezy.ttf");     
            tv.setTypeface(face);
            tv.setText("MY PICTURES"); 
        }

        InfiniteGallery galleryOne = (InfiniteGallery) findViewById(R.id.galleryOne);
        galleryOne.setAdapter(new InfiniteGalleryAdapter(this));     
    }
}