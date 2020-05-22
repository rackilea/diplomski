@Override
public void onSensorChanged(SensorEvent event) {

    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
        // Execute accelerometer code
    }
    if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
        // Execute gyroscope code
    }
}