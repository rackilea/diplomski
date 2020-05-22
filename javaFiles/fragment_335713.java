super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //set up the mapView and show the MyLocationOverlay
    mapView = findViewById(R.id.mapview);
    //... shortened ...
    mapView.getOverlays().add(messagesOverlay); // <== here you are adding null, the messagesOevrlay variable is not yet initialized
    mapView.getOverlays().add(myLocationOverlay);

    //..shortened...


    // here you are creating the instance
    messagesOverlay = new ItemizedIconOverlay<OverlayItem>(items, getResources().getDrawable(R.drawable.briefumschlag), null, this);