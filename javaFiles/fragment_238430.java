package com.example.a291019;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView txtLocation = findViewById(R.id.txtLocation);

    LocationManager locationManager = (LocationManager) 
 getSystemService(Context.LOCATION_SERVICE);
    if (ContextCompat.checkSelfPermission(this, 
 Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_DENIED || 
 ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) 
 != PackageManager.PERMISSION_DENIED) {

        assert locationManager != null;
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 10, 
          new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.d("GPS", "Latitude" + location.getLatitude() + " et longitude " + 
                    location.getLongitude());
                txtLocation.setText(String.format("Latitude%s et longitude %s", 
                    location.getLatitude(), location.getLongitude()));
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }

        });
    }

  }
}