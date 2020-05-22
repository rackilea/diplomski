public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener, ActivityCompat.OnRequestPermissionsResultCallback {

    private List<Geofence> mGeofenceList = new ArrayList<>();

    private GeofencingClient gfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        gfc = LocationServices.getGeofencingClient(getApplicationContext());

        mGeofenceList.add(new Geofence.Builder().setRequestId("aa").setCircularRegion(50.32, 43.23, 232).setExpirationDuration(-1L).setTransitionTypes(
                Geofence.GEOFENCE_TRANSITION_ENTER | Geofence.GEOFENCE_TRANSITION_EXIT).build());


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }

        else {
            setGeofences();
        }

    }


    private GeofencingRequest getGeofencingRequest(){
        if (mGeofenceList.isEmpty()){
            return null;}
        Log.v("mGeofenceList", mGeofenceList.toString());
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER |
                GeofencingRequest.INITIAL_TRIGGER_EXIT);
        builder.addGeofences(mGeofenceList);
        return builder.build();
    }

    private PendingIntent mGeofencePendingIntent;

    private PendingIntent getGeofencePendingIntent(){
        if (mGeofencePendingIntent != null){
            return mGeofencePendingIntent;
        }
        Intent intent = new Intent(getApplicationContext(), Object.class);
        mGeofencePendingIntent =  PendingIntent.getService(getApplication(),
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return mGeofencePendingIntent;
    }

    @SuppressLint("MissingPermission")
    private void setGeofences(){
        GeofencingRequest geofencingRequest = getGeofencingRequest();
        PendingIntent pi = getGeofencePendingIntent();
        gfc.addGeofences(geofencingRequest, pi)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Geofences", "geofencing set up succesfully");
                        Toast.makeText(MapsActivity.this, "Geofences set up", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(MapsActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Geofence", e.toString());
                        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
                            Log.e("Provider", "Provider is not avaible");
                        }
                        if (!manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
                            Log.e("Network Provider", "Provider is not avaible");
                        }

                    }
                });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        setGeofences();

    }

}