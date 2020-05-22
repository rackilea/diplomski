public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private SeekBar mRadiusSeekBar;

    private Circle mCircle;
    private double mCircleRadius = 250;
    private LatLng mCircleCenter = new LatLng(38.432398, 27.155882);

    private void addCircle(){
        mCircle = mMap.addCircle(new CircleOptions()
                .strokeWidth(4)
                .radius(mCircleRadius)
                .center(mCircleCenter)
                .strokeColor(Color.parseColor("#D1C4E9"))
                .fillColor(Color.parseColor("#657C4DFF")));
    }

    private List<LatLng> mPoints = new ArrayList<>();
    private List<Marker> mMarkers = new ArrayList<>();

    private void addMarkers(){
        LatLng mPoint1 = new LatLng(38.440925, 27.153672);
        LatLng mPoint2 = new LatLng(38.440700, 27.155877);
        LatLng mPoint3 = new LatLng(38.438402, 27.153988);
        LatLng mPoint4 = new LatLng(38.433767, 27.155410);
        LatLng mPoint5 = new LatLng(38.432143, 27.156049);
        LatLng mPoint6 = new LatLng(38.427804, 27.153486);
        LatLng mPoint7 = new LatLng(38.424637, 27.152007);
        LatLng mPoint8 = new LatLng(38.421315, 27.153216);
        LatLng mPoint9 = new LatLng(38.418219, 27.154731);
        LatLng mPoint10 = new LatLng(38.414628, 27.156085);

        mPoints.add(mPoint1);
        mPoints.add(mPoint2);
        mPoints.add(mPoint3);
        mPoints.add(mPoint4);
        mPoints.add(mPoint5);
        mPoints.add(mPoint6);
        mPoints.add(mPoint7);
        mPoints.add(mPoint8);
        mPoints.add(mPoint9);
        mPoints.add(mPoint10);

        BitmapDescriptor bd = BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_VIOLET);

        for(int i = 0; i<mPoints.size(); i++){
            Marker marker = mMap.addMarker(
                    new MarkerOptions()
                            .visible(false)
                            .position(mPoints.get(i)).icon(bd));

            mMarkers.add(marker);
        }
    }

    private void filterMarkers(double radiusForCircle){
        mCircle.setRadius(radiusForCircle);
        float[] distance = new float[2];
        for(int m = 0; m < mMarkers.size(); m++){
            Marker marker = mMarkers.get(m);
            LatLng position = marker.getPosition();
            double lat = position.latitude;
            double lon = position.longitude;

            Location.distanceBetween(lat, lon, mCircleCenter.latitude,
                    mCircleCenter.longitude, distance);

            boolean inCircle = distance[0] <= radiusForCircle;
            marker.setVisible(inCircle);
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mRadiusSeekBar = (SeekBar) findViewById(R.id.seekbar);

        mRadiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                filterMarkers(progress * 10);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory
                .newLatLngZoom(mCircleCenter, 12));

        addMarkers();
        addCircle();
    }
}