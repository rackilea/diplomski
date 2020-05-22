import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.*;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.*;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity
    implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private final LatLng MainHousing = new LatLng(49.83511, 24.01446);
    private final LatLng FirstHousing = new LatLng(49.83533, 24.01004);
    private final LatLng FifthHousing = new LatLng(49.835, 24.00824);
    private static final int REQUEST_LOCATION = 1;

    GoogleMap googleMap;
    LatLng myPosition;
    Spinner spinner;
    PolylineOptions pOptions;
    Marker currLocationMarker;
    SupportMapFragment mFragment;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        List<String> list = new ArrayList<>();
        list.add("Головний корпус");
        list.add("I корпус");
        list.add("V корпус");

        spinner = (Spinner) findViewById(R.id.spinner);
        pOptions = new PolylineOptions();

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        mFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mFragment.getMapAsync(this);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                       int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION:
                if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission Granted
                    Toast.makeText(SOMapsActivity.this, "LOCATION Accepted", Toast.LENGTH_SHORT)
                        .show();
                } else {
                // Permission Denied
                    Toast.makeText(SOMapsActivity.this, "LOCATION Denied", Toast.LENGTH_SHORT)
                        .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        buildGoogleApiClient();
        mGoogleApiClient.connect();
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {

            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_LOCATION);
        }

        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
            mGoogleApiClient);
        if (mLastLocation != null) {

            myPosition = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(myPosition);
            markerOptions.title("Current Position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            currLocationMarker = googleMap.addMarker(markerOptions);
        }

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(5000); //5 seconds
        mLocationRequest.setFastestInterval(3000); //3 seconds
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
    //mLocationRequest.setSmallestDisplacement(0.1F); //1/10 meter

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        pOptions.add(myPosition).add(MainHousing).width(5).color(Color.BLUE).geodesic(true);
                        googleMap.addPolyline(pOptions);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MainHousing, 17));
                        break;
                    case 1:
                        pOptions.add(myPosition).add(FirstHousing).width(5).color(Color.BLUE).geodesic(true);
                        googleMap.addPolyline(pOptions);
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FirstHousing, 17));
                        break;
                    case 2:
                        pOptions.add(myPosition).add(FifthHousing).width(5).color(Color.BLUE).geodesic(true);
                        googleMap.addPolyline(pOptions);
                            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(FifthHousing, 17));
                        break;
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });
        }
//......
}