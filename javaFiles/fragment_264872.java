@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

   /* showContacts(); // Ask permission to read contacts
    showlogs(); // Ask permission to create file where we write the logs*/

    setContentView(R.layout.activity_main);

    // set up the action toolbar

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    // set up the listview by retrieving contacts

    mContactsList = (ListView) findViewById(R.id.listView);
    //setup an adapter to populate the listview
    mCursorAdapter = new SimpleCursorAdapter(
            this,
            R.layout.contacts_list_item,
            null,
            FROM_COLUMNS, TO_IDS,
            0);

        // Sets the adapter for the ListView
    mContactsList.setAdapter(mCursorAdapter);
    // set up the listener for the listview - it will be handled by code in this activity
    mContactsList.setOnItemClickListener(this);
    //call the cursor loader
    getLoaderManager().initLoader(0, null, this);
    // set up the "zoom" button

    final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    // set up the click action - toggle between big and normal layouts
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            toggleDisplaySize();
        }
    });

    // set up the client for google play services so we can request activity detection later

askpermissions();
    }


void permissionGranted()
{ Log.i("START", "Start");
    writefile("START");
    mApiClient = new GoogleApiClient.Builder(this)
            .addApi(ActivityRecognition.API)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build();
    mApiClient.connect();

            mContactsList.setOnScrollListener(new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) 
    {
                Log.i("Scroll", "Scroll list"); // When user scrolled the list
                writefile("SCROLL");
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    });}

public static boolean hasPermissions(Context context, String... permissions) {
if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
    for (String permission : permissions) {
        if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }else{
permissionGranted();}
    }
}
return true;
}

public void askpermissions(){
int PERMISSION_ALL = 1;
String[] PERMISSIONS = {Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_EXTERNAL_STORAGE};

if(!hasPermissions(this, PERMISSIONS)){
    ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
}else 
permissionGranted();
}