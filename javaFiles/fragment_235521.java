public class MainActivity extends Activity implements returnListListener {
    // Local Variables
    Context context;
    String mTAG = "NETWORK ACTIVITY - MainActivity Class";
    String mUrlString = "http://www.giantbomb.com/api/games/?api_key=84bb1f7ad08b299e6c29992eff7ed6278f406a15&format=json&limit=5&sort=original_release_date:asc&filter=expected_release_year:";
    String[] mReleaseYears;
    public static TextView resultsView;
    ListView mList;
    TextView name;
    TextView deck;
    TextView release;
    Boolean mConnected = false;


    ArrayList<HashMap<String, String>> gameList;
    // Node names from JSON Data
    String TAG_PARENT = "results";
    String TAG_NAME = "name";
    String TAG_DECK = "deck";
    String TAG_RELEASE = "expected_release_year";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_form);

        // Setting context local var to this activity.
        context = this;
        resultsView = (TextView) findViewById(R.id.results_view);
        // Setting mReleaseYears Local Var to String Array from resources
        mReleaseYears = getResources().getStringArray(R.array.yearArray);
        mList = (ListView) findViewById(R.id.game_list);
        // Creating Spinner Adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_spinner_item, mReleaseYears);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Creating the spinner
        Spinner viewSpinner = (Spinner) findViewById(R.id.release_years);
        // Setting the spinners adapter to created adapter 'spinnerAdapter'
        viewSpinner.setAdapter(spinnerAdapter);
        // Setting
        viewSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                // Setting Local Var Boolean 'mConnected' to the current
                // context's status
                mConnected = NetworkConn.grabConnectionStatus(context);
                // If connected...
                if (mConnected) {
                    // Performing a search using performSearch method based off
                    // current selected spinner position. Passes is data from
                    // array (mReleaseYears) based on selection to allow user
                    // manipulation of data.
                    //Data.performSearch(mUrlString + mReleaseYears[position]);
                    new Data(MainActivity.this).execute(mUrlString+ mReleaseYears[position]);
                    // If not connected...
                } else {
                    // Setting the result's view text
                    resultsView.setText(R.string.networkError);
                    AlertDialog.Builder adb = new AlertDialog.Builder(context);
                    adb.setMessage(R.string.networkError);
                    adb.setCancelable(true);
                    adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog errorAlert = adb.create();
                    errorAlert.show();
                }
            }

            // Method onNothingSelected...self explanatory method not utilized
            // at the moment.
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        // Setting list's item click listener

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void returnList(final ArrayList<HashMap<String, String>> list) {
        // TODO Auto-generated method stub
        // set adapter with list here
          ListAdapter adapter = new SimpleAdapter(MainActivity.this,
                list, R.layout.list_view, new String[] {
                        TAG_NAME, TAG_RELEASE }, new int[] {
                        R.id.name, R.id.release });
         mList.setAdapter(adapter);
         mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                // Method to be called upon item click within list
                public void onItemClick(AdapterView<?> parent,
                        View view, int position, long id) {
                    // Setting the resultsView background color to dark
                    // gray (in case an error occurs, and it's currently
                    // red)
                    resultsView.setBackgroundColor(Color.DKGRAY);
                    // Setting the resultView to display the current
                    // position's (in list) item details based off
                    // pulled in json data thats stored in gameList
                    resultsView.setText("Game: "
                            + list.get(+position).get(TAG_NAME)
                            + "\n"
                            + "About Game: "
                            + list.get(+position).get(TAG_DECK)
                            + "\n"
                            + "Release Year: "
                            + list.get(+position).get(TAG_RELEASE));
                }
            });
    }

}