private SensorEventListener mSensorEventListener = new SensorEventListener() {

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_GRAVITY) {

            mGravity = event.values.clone();

        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {

            mMagnetic = event.values.clone();

        }

        if (mGravity != null && mMagnetic != null) {

            /* Create rotation Matrix */
            float[] rotationMatrix = new float[9];
            if (SensorManager.getRotationMatrix(rotationMatrix, null,
                    mGravity, mMagnetic)) {

                /* Compensate device orientation */
                // http://android-developers.blogspot.de/2010/09/one-screen-turn-deserves-another.html
                float[] remappedRotationMatrix = new float[9];
                switch (getWindowManager().getDefaultDisplay()
                        .getRotation()) {
                case Surface.ROTATION_0:
                    SensorManager.remapCoordinateSystem(rotationMatrix,
                            SensorManager.AXIS_X, SensorManager.AXIS_Y,
                            remappedRotationMatrix);
                    break;
                case Surface.ROTATION_90:
                    SensorManager.remapCoordinateSystem(rotationMatrix,
                            SensorManager.AXIS_Y,
                            SensorManager.AXIS_MINUS_X,
                            remappedRotationMatrix);
                    break;
                case Surface.ROTATION_180:
                    SensorManager.remapCoordinateSystem(rotationMatrix,
                            SensorManager.AXIS_MINUS_X,
                            SensorManager.AXIS_MINUS_Y,
                            remappedRotationMatrix);
                    break;
                case Surface.ROTATION_270:
                    SensorManager.remapCoordinateSystem(rotationMatrix,
                            SensorManager.AXIS_MINUS_Y,
                            SensorManager.AXIS_X, remappedRotationMatrix);
                    break;
                }

                /* Calculate Orientation */
                float results[] = new float[3];
                SensorManager.getOrientation(remappedRotationMatrix,
                        results);

                /* Get measured value */
                float current_measured_bearing = (float) (results[0] * 180 / Math.PI);
                if (current_measured_bearing < 0) {
                    current_measured_bearing += 360;
                }

                /* Smooth values using a 'Low Pass Filter' */
                current_measured_bearing = current_measured_bearing
                        + SMOOTHING_FACTOR_COMPASS
                        * (current_measured_bearing - compass_last_measured_bearing);

                /* Update normal output */
                visual_compass_value.setText(String.valueOf(Math
                        .round(current_bearing))
                        + getString(R.string.degrees));

                /*
                 * Update variables for next use (Required for Low Pass
                 * Filter)
                 */
                compass_last_measured_bearing = current_measured_bearing;

            }
        }
    }
};