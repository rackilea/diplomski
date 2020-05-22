private volatile boolean heavyAlgRunning = false;

@Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
            mGravity = event.values;
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD)
            mGeomagnetic = event.values;
        if (mGravity != null && mGeomagnetic != null) {

            float R[] = new float[9];
            float I[] = new float[9];
            boolean success = SensorManager.getRotationMatrix(R, I, mGravity,
                    mGeomagnetic);
            if (success) {

                float orientation[] = new float[3];
                SensorManager.getOrientation(R, orientation);
                azimuth_angle = (float) (orientation[0]*180/Math.PI); 
                pitch_angle = (float) (orientation[1]*180/Math.PI);
                roll_angle = (float) (orientation[2]*180/Math.PI);
        p.setText(String.valueOf(pitch_angle));
                 r.setText(String.valueOf(roll_angle));
                 y.setText(String.valueOf(azimuth_angle));
                 if (heavyAlgRunning) return;
                 heavyAlgRunning = true;

                 new Thread(new Runnable() {

                     public void run()
                       {


                          try 
                           {

                            Locations = Algo( pitch_angle, roll_angle,
                                        azimuth_angle);
                            Thread.sleep(500);
                           } 
                           catch (Throwable e) 
                           {
                                // TODO Auto-generated catch block
                                Log.e("t","t",e);
                                //e.printStackTrace();
                            }
         //                    finally {
         //                        heavyAlgRunning =false;
          //                  }

                              heavyAlgRunning =false;

                         }

                        }).start();
        }