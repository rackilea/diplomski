@Override
protected void onCreate(.....) {
     super.onCreate(....);
     mMapView = new MapView(this, YOUR_MAP_API_KEY); //pass key to MapView Constructor here
     setContentView(mMapView);
  //   ....
}