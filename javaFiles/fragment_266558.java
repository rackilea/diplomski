@Override
protected void onCreate(Bundle savedInstanceState) {
  MapView mapView = MapView(MainActivity.this, mapOpts);
  // other logic/initializations

  ViewGroup mapLayout = findViewById(R.id.mapLayout);
  mapLayout.addView(mapView); // might have to specify index param if you need buttons