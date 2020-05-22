@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
Places.initialize(getApplicationContext(), YOUR_API_KEY);
    PlacesClient placesClient = Places.createClient(this);

        // Loads the actionbar with custom menu maps_menu.xml
        getSupportActionBar();

        // Creates a listener than monitors the state of the firebase authentication.  If the state
        // of the authentication changes at any point during the app usage then the function will be
        // called.  If there is found to be no current user (logged out, token expired etc.) then
        // the user will be redirected to the sign in (Auth) activity.
        fbAuth = FirebaseAuth.getInstance();
        fbUser = FirebaseAuth.getInstance().getCurrentUser();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (fbUser == null){
                    startActivity(new Intent(MapsActivity.this, AuthActivity.class));
                    finish();
                }
            }
        };

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }