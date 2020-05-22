public class AlertViewOnMap extends Activity {

    //declarations
    ArrayList<String> dateCreatedAtList = new ArrayList<String>();

    TextView busNumberTextView;
    TextView descriptionTextView;
    TextView alertTimeTextView;

    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private HashMap<Marker,Alert> markerDataMap;


    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(com.fourbox.bocterapp.R.layout.details_design);

        busNumberTextView = (TextView) findViewById(R.id.textViewAlertBusNumber);
        descriptionTextView = (TextView) findViewById(R.id.textViewAlertDescription);
        alertTimeTextView = (TextView) findViewById(R.id.textViewAlertTime);

        busNumber = getIntent().getIntExtra("busNumber", 0);
        description = getIntent().getStringExtra("description");
        coordinatesLatitude =  getIntent().getDoubleExtra("coordinatesLatitude", 0);
        coordinatesLongitude = getIntent().getDoubleExtra("coordinatesLongitude", 0);

        alertTime.setTime(getIntent().getLongExtra("createdAt", 0));

        busNumberList = getIntent().getStringArrayListExtra("busNumberList");
        descriptionList = getIntent().getStringArrayListExtra("descriptionList");
        coordinatesLatitudeList =     getIntent().getStringArrayListExtra("coordinatesLatitudeList");
        coordinatesLongitudeList =     getIntent().getStringArrayListExtra("coordinatesLongitudeList");
        dateCreatedAtList = getIntent().getStringArrayListExtra("dateCreatedAtList");

        GoogleMap mMap;
        mMap = ((MapFragment)     getFragmentManager().findFragmentById(com.fourbox.bocterapp.R.id.mapFragment)).getMap();
        reuniteAlertListFromGetExtra();
        placeAllMarkersOnMap(mMap, alertsList);

        LatLng latLng = new LatLng(coordinatesLatitude, coordinatesLongitude);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(latLng) // Center Set
                .zoom(18.0f)                // Zoom
                .bearing(0)                // Orientation of the camera to east
                .tilt(30)                   // Tilt of the camera to 30 degrees
                .build();                   // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        busNumberTextView.setText(String.valueOf(busNumber));
        descriptionTextView.setText(description);
        alertTimeTextView.setText(String.valueOf(dateFormat.format(alertTime)));
    }

    public void placeAllMarkersOnMap(GoogleMap mMap, ArrayList<Alert> alertsList) {
        markerDataMap = new HashMap<Marker, Alert>();
        for(int i=0; i<alertsList.size(); i++) {
            markerDataMap.put(mMap.addMarker(new MarkerOptions()
                    .position(new     LatLng(alertsList.get(i).getCoordinates().getLatitude(),     alertsList.get(i).getCoordinates().getLongitude()))
                    .title(alertsList.get(i).getDescription())
                    .snippet(String.valueOf(alertsList.get(i).getBusNumber())
                    )),alertsList.get(i));

        }
    }

    public void reuniteAlertListFromGetExtra() {

        for (int i =0; i<busNumberList.size(); i++) {

            Alert alert = new Alert();
            ParseGeoPoint parseGeoPoint = new ParseGeoPoint();

            parseGeoPoint.setLatitude(Double.valueOf(coordinatesLatitudeList.get(i)));
            parseGeoPoint.setLongitude(Double.valueOf(coordinatesLongitudeList.get(i)));

            alert.setBusNumber(Integer.valueOf(busNumberList.get(i)));
            alert.setDescription(descriptionList.get(i));
            alert.setCoordinates(parseGeoPoint);
            alert.setCreatedAt(new Date(Long.valueOf(dateCreatedAtList.get(i))));

            alertsList.add(alert);
        }
    }

    public GoogleMap.OnMarkerClickListener getInfoMarkerClickListener() {
        return new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Alert alert = markerDataMap.get(marker);
                busNumberTextView.setText(alert.getDescription());
                descriptionTextView.setText(alert.getBusNumber());
                alertTimeTextView.setText(dateCreatedAtList.get(alert.getId()));
                marker.showInfoWindow();
                return true;
            }
        };
    }
}