@Override
public void onSensorChanged(SensorEvent event) {
    // TODO Auto-generated method stub
    if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER 
        && event.sensor.getType() == Sensor.TYPE_GRAVITY) {
        getAccelerometer(event);
        }
}