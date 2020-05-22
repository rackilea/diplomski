protected void onCreate(Bundle savedInstanceState) {
  ....
  mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
  if ((accelerometer  = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null ) {...}
  if ((magnetometer   = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null ) {...}
  ....
}
// register the sensors only one time within onResume not in onCreate
@Override
protected void onResume() {
    super.onResume();
    mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
    mSensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
  }