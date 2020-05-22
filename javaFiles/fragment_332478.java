public void onSensorChanged(SensorEvent se) {

float degPitch = 0;
float degRoll = 0;
float degYaw = 0;
float radPitch = 0;
float radRoll = 0;
float radYaw = 0;

if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
    mAccelerometerResult = se.values;
    Log.d("onSensorChanged", "Accelerometer: " + mAccelerometerResult.length);
}

if (se.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
    mMagneticFieldResult = se.values;
    Log.d("onSensorChanged", "Magnetic Field: " + mMagneticFieldResult.length);
}

if (mAccelerometerResult != null && mMagneticFieldResult != null) {

//~~~This is where the 3x3 matrix has changed to a 4x4.
    float[] rotation = new float[16];
    float[] inclination = new float[16];

    boolean rotationMatrixCheck = mSensorManager.getRotationMatrix(rotation, inclination, mAccelerometerResult, mMagneticFieldResult);

    if (rotationMatrixCheck) {

        float[] orientation = new float[3];

//~~~This is where the rotational matrix is remapped to be used in portrait mode.
        float[] remappedRotation = new float[16];
        SensorManager.remapCoordinateSystem(rotation, SensorManager.AXIS_X, SensorManager.AXIS_Z, remappedRotation);

        mSensorManager.getOrientation(rotation, orientation);


        radYaw = orientation[0];      //Yaw = Z axis
        radPitch = orientation[1];      //Pitch = X axis
        radRoll = orientation[2];      //Roll = Y axis

        degYaw = round((float) Math.toDegrees(radYaw), 2);
        degPitch = round((float)Math.toDegrees(radPitch), 2);
        degRoll = round((float)Math.toDegrees(radRoll), 2);


        if ((counter % 10) == 0) {
            //mYawTextView.setText(degYaw + "°");
            mPitchTextView.setText(degPitch + "°");
            mRollTextView.setText(degRoll + "°");
            counter = 0;
        } else {
            counter++;
        }
    }
}