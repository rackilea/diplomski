CarDataset cardata;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_geolocalizcao);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.

    Intent i = getIntent();

    //use instance variable:
    cardata = (CarDataset) i.getExtras().getParcelable("select");

    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

}