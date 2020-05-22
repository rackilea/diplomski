@Override
public void onSensorChanged(SensorEvent event) {
  acclX = event.values[0];
  acclY =event.values[1];
  acclZ = event.values[2];
  fireUpdate(event);