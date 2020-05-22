SensorManager sensorManager = (SensorManager)HeadTracker.this.mContext.getSystemService("sensor");

for (int sensorType : HeadTracker.INPUT_SENSORS) {
  Sensor sensor = sensorManager.getDefaultSensor(sensorType);
  sensorManager.registerListener(HeadTracker.this.mSensorEventListener, sensor, 0, handler);
}