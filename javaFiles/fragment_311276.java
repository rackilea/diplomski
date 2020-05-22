mainActivity.java:

package com.example.manju.helpme;


import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements ConnectionCallbacks, OnConnectionFailedListener {

/* called when user clicks ALERT! button*/

protected Location mLastLocation;
protected TextView mLatitudeText;
protected TextView mLongitudeText;
protected GoogleApiClient mGoogleApiClient;
protected static final String TAG = "basic-location-sample";


public void sendMessage() {

    String phoneNo = "8152873220";
    String message = "hi";
    SmsManager smsManager = SmsManager.getDefault();
    smsManager.sendTextMessage(phoneNo, null, message, null, null);

}

protected synchronized void buildGoogleApiClient() {
    mGoogleApiClient = new GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build();

}
@Override
protected void onStart() {
    super.onStart();
    mGoogleApiClient.connect();
}

@Override
protected void onStop() {
    super.onStop();
    if (mGoogleApiClient.isConnected()) {
        mGoogleApiClient.disconnect();
    }
}

/**
 * Runs when a GoogleApiClient object successfully connects.
 */
@Override
public void onConnected(Bundle connectionHint) {
    // Provides a simple way of getting a device's location and is well suited for
    // applications that do not require a fine-grained location and that do not need location
    // updates. Gets the best and most recent location currently available, which may be null
    // in rare cases when a location is not available.
    mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    if (mLastLocation != null) {
        mLatitudeText.setText(String.valueOf(mLastLocation.getLatitude()));
        mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
    } else {
        Toast.makeText(this,"No location detected, Make sure that location is enabled in the device", Toast.LENGTH_LONG).show();
    }
}

@Override
public void onConnectionFailed(ConnectionResult result) {
    // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
    // onConnectionFailed.
    Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
}


@Override
public void onConnectionSuspended(int cause) {
    // The connection to Google Play services was lost for some reason. We call connect() to
    // attempt to re-establish the connection.
    Log.i(TAG, "Connection suspended");
    mGoogleApiClient.connect();
}






@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    buildGoogleApiClient();


   Button btnAlert = (Button)findViewById(R.id.btn_Alert);
    Button btnAddGuardian = (Button)findViewById(R.id.btn_Add_Guardian);
    Button btnRemoveGuardian= (Button)findViewById(R.id.btn_Remove_Guardian);



    btnAlert.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            sendMessage();
        }
    });

    btnAddGuardian.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });


    btnRemoveGuardian.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}
}