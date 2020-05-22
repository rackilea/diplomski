package com.dani;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FM extends Activity implements SensorEventListener {
private static final double nbElements = 30;
private SensorManager sensorManager;
private Sensor accelerometer;
Button boton1;

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fm);
      boton1 = (Button) findViewById(R.id.button1);

      sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
      boolean accelSupported = sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),  
      SensorManager.SENSOR_DELAY_FASTEST);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (!accelSupported) {
            sensorManager.unregisterListener(this, accelerometer);
            ((TextView) findViewById(R.id.textView1)).setText("Accelerometer not
   detected");
        }


        }  

@Override
public void onAccuracyChanged(Sensor arg0, int arg1) {
    // TODO Auto-generated method stub

}
long now = 0;
long time = 0;
int temp = 0;

public void onSensorChanged(SensorEvent event) {
    long tS;
    // only if the event is from the accelerometer
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

        tS = event.timestamp;

        if (now != 0) {
            temp++;
            if (temp == nbElements) {
                time = tS - now;
                ((TextView) findViewById(R.id.textView1)).setText("Frecuencia : " + 
 (nbElements * 1000000000 / time)
                        + " Hz");
                temp = 0;
            }
        }
        // To set up now on the first event and do not change it while we do not have  
 "nbElements" events
        if (temp == 0) {
            now = tS;
        }
    }


boton1.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View v) {
    // TODO Auto-generated method stub
    Intent i = new Intent(FM.this, PruebaActivity.class);
    startActivity(i);   
 }
 });
}

public void onClickQuit(View v) {
finish();
}

}