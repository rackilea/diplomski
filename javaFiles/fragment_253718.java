/**
 * Initialize the Sensors (Gravity and magnetic field, required as a compass
 * sensor)
 */
private void initSensors() {

    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    Sensor mSensorGravity = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
    Sensor mSensorMagneticField = sensorManager
            .getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    /* Initialize the gravity sensor */
    if (mSensorGravity != null) {
        Log.i(TAG, "Gravity sensor available. (TYPE_GRAVITY)");
        sensorManager.registerListener(mSensorEventListener,
                mSensorGravity, SensorManager.SENSOR_DELAY_GAME);
    } else {
        Log.i(TAG, "Gravity sensor unavailable. (TYPE_GRAVITY)");
    }

    /* Initialize the magnetic field sensor */
    if (mSensorMagneticField != null) {
        Log.i(TAG, "Magnetic field sensor available. (TYPE_MAGNETIC_FIELD)");
        sensorManager.registerListener(mSensorEventListener,
                mSensorMagneticField, SensorManager.SENSOR_DELAY_GAME);
    } else {
        Log.i(TAG,
                "Magnetic field sensor unavailable. (TYPE_MAGNETIC_FIELD)");
    }
}