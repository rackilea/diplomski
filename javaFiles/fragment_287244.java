public class MainActivity extends Activity {

    private ListView placesList;
    private List<Place> places = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placesList = (ListView) findViewById(R.id.PlacesList);

        new CheckInTask().execute();

        // start retrieving the list of nearby places
        new ListOfPlacesAsyncRetriever().execute();

        placesList.setOnItemClickListener(placesListClickListener);

    }

    public void refresh(View test){

    }


   .............

   ...........
}