//load static layout from: res/layout/activity_main.xml
    setContentView(R.layout.activity_main);

    //get Map Fragment and retrieve GoogleMap object
    MapFragment mapFragment = (MapFragment) getFragmentManager()
            .findFragmentById(R.id.map);
    map = mapFragment.getMap();