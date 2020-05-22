protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    AndroidGraphicFactory.createInstance(this.getApplication());

    setContentView(R.layout.activity_main);
    this.mapView = (MapView) findViewById(R.id.mapView);

    this.mapView.setClickable(true);
    ...