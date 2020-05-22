public class YourActivity extends Activity
{
    ArrayList<String> reviewsArray = new ArrayList<String>();
    ListView reviewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {   
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youractivity);

        reviewList = (ListView) findViewById(R.id.yourListViewId);

        //fill your reviewsArray...

        ArrayAdapter<String> reviewsAdapter = new ArrayAdapter<String>(context, R.layout.reviewLayout, reviewsArray);
        reviewsList.setAdapter(reviewsAdapter);
    }
}