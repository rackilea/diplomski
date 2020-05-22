mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
mListener = new SensorListener() {
    public void onSensorChanged(int sensor, float[] values) {
        if (Config.LOGD) Log.d(TAG, "sensorChanged (" + values[0] + ", " + values[1] + ", " + values[2] + ")");
        mValues = values;
        if (mView != null) {
            mView.invalidate();
        }
    }
mSensorManager.registerListener(mListener, 
                    SensorManager.SENSOR_ORIENTATION,
                    SensorManager.SENSOR_DELAY_GAME);