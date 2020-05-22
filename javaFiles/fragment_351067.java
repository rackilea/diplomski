package com.ice_os.android.ad.pound_a_politician;

import java.util.Hashtable;

import com.ice_os.android.ad.pound_a_politician.R;
import com.inneractive.api.ads.InneractiveAd;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;

public class Menu extends Activity {
     Hashtable<InneractiveAd.IaOptionalParams, String> metaData = new Hashtable<InneractiveAd.IaOptionalParams, String>();
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
         setContentView(R.layout.main);
            final TableLayout lnr = (TableLayout) findViewById(R.id.table);
            LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, new IntentFilter("InneractiveAd"));
            if (!InneractiveAd.displayAd(Menu.this, lnr, "zeitue_PoundAPoliticianAdversion_Android", InneractiveAd.IaAdType.Banner, 120, Menu.this.metaData))
                noConnectivity();


        Button Start = (Button)findViewById(R.id.start);
        Start.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent StartIntent = new Intent(Menu.this,MainActivity.class);
                startActivity(StartIntent);
            }
        });

        Button Help = (Button)findViewById(R.id.help);
        Help.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent HelpIntent = new Intent(Menu.this,Help.class);
                startActivity(HelpIntent);
            }
        });



        Button Options = (Button)findViewById(R.id.options);
        Options.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent OptionsIntent = new Intent(Menu.this,Options.class);
                startActivity(OptionsIntent);
            }
        });

    }

    public Activity getActivity(){
        return this.getActivity();
    }


    public void noConnectivity() {
        AlertDialog alertDialog = new AlertDialog.Builder(Menu.this).create();
        alertDialog.setTitle("This application is free but requires an internet connection");
        alertDialog.setMessage("Please configure your connectivity settings and re-try");
        alertDialog.setButton("Exit", new DialogInterface.OnClickListener() {
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
                  onBackPressed();
            } });
        alertDialog.show();
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            @SuppressWarnings("unused")
            String message = intent.getStringExtra("message");
        }
    };

    @Override
    protected void onDestroy() {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
      super.onDestroy();
    }

}