private SensorEventListener sensorEventListener = new SensorEventListener() {
    private long lastTimestamp;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        long currentTimestamp = sensorEvent.timestamp;
        if (currentTimestamp - lastTimestamp >= TimeUnit.SECONDS.toNanos(10)) {
            lastTimestamp = currentTimestamp;
            Toast.makeText(mContext, "10 seconds", Toast.LENGTH_SHORT).show();
            //Here you can compare sensor data
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
};