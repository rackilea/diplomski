@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstance);

mGoogleApiClient = new GoogleApiClient.Builder(this)
.addApi(Drive.API)
.addScope(Drive.SCOPE_FILE)
.addConnectionCallbacks(this)
.addOnConnectionFailedListener(this)
.build();
}


After you create the client, you must connect it for authorization to occur.

@Override
protected void onStart() {
super.onStart();
mGoogleApiClient.connect();
}