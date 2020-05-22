public class myActivity extends Activity implements OnItemSelectedListener
{
    //this counts how many Gallery's are on the UI
    private int mGalleryCount=0;

    //this counts how many Gallery's have been initialized
    private int mGalleryInitializedCount=0;

    //UI reference
    private Gallery mGallery;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.myxmllayout);

        //get references to UI components
        mGallery = (Gallery) findViewById(R.id.mygallery);

        //trap selection events from gallery
        mGallery.setOnItemSelectedListener(this);

        //trap only selection when no flinging is taking place
        mGallery.setCallbackDuringFling(false);

        //
        //do other stuff like load images, setAdapter(), etc
        //

        //define how many Gallery's are in this view
        //note: this could be counted dynamically if you are programmatically creating the view
        mGalleryCount=1;

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        if (mGalleryInitializedCount < mGalleryCount)
        {
            mGalleryInitializedCount++;
        }
        else
        {
            //only detect selection events that are not done whilst initializing
            Log.i(TAG, "selected item position = " + String.valueOf(position) );
        }

    }

}