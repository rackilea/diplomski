package com.example.detectinternetconnection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AndroidDetectInternetConnectionActivity  extends Activity implements   OnClickListener {

Boolean isInternetPresent = false;
ConnectionDetector cd;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    Button btnStatus = (Button) findViewById(R.id.btnStatus);
    cd = new ConnectionDetector(getApplicationContext());
    btnStatus.setOnClickListener(this);
}

@Override
public void onClick(View v) {
    isInternetPresent = cd.isConnectingToInternet();
    if (isInternetPresent) {

        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(
                AndroidDetectInternetConnectionActivity .this);
        builder.setTitle("Internet Connection");
        builder.setCancelable(false);

        builder.setPositiveButton("Continue",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        startActivity(new Intent(AndroidDetectInternetConnectionActivity .this,
                                MainActivity2 .class));
                    }
                });

        alert = builder.create();
        alert.show();
    }

    else {

        AlertDialog alert;
        AlertDialog.Builder builder = new AlertDialog.Builder(
                AndroidDetectInternetConnectionActivity .this);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Please Connect To Internet");
        builder.setCancelable(false);

        builder.setPositiveButton("Exit",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        alert = builder.create();
        alert.show();
    }
}

}