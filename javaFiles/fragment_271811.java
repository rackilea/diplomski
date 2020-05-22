package com.example.servicesample;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import com.example.servicesample.MyService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;

public class MainActivity extends Activity {

    private IntentFilter mIntentFilter = new IntentFilter(MyService.ROOM_STATUS_BROADCAST);


    private BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.receivedBroadcast(intent);       
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startMyService();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }   

    void startMyService()
    {
        // You can move this code to be executed on a button click or something else
        // It will start a service
        startService(new Intent(this, MyService.class));
    }   

    @Override
    protected void onResume()
    {
        super.onResume();

        LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, mIntentFilter);
    }

    @Override
    protected void onPause()
    {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);

        super.onPause();
    }   

     private void receivedBroadcast(Intent i) {
         Integer roomNumber = i.getIntExtra(MyService.ROOM_STATUS_BROADCAST_EXTRA_ROOM_NUMBER, 0);
        Boolean roomStatus = i.getBooleanExtra(MyService.ROOM_STATUS_BROADCAST_EXTRA_STATUS, false);

        // Let's do here whatever we want with received status (as example, update UI)
        Log.d("SomeTag", "Room number "+roomNumber.toString() + " got new status " + roomStatus.toString());
     }  

}