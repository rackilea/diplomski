public void onSensorChanged(SensorEvent event) {
    Sensor sensor = event.sensor;
    a = event.values[0];
    b = event.values[1];
    c = event.values[2];

    if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {

        DBHelper.getInstance().insert(a, b, c);
    }
}