public void onSensorChanged(SensorEvent event) 
 {
     if( event.sensor.getType() == Sensor.TYPE_LIGHT)
     {
        currentLux = event.values[0];
        if (currentLux > maxLux)
          maxLux = currentLux;
     }
 }