//implement SensorEventListener
public class SensorActivity extends Activity, implements SensorEventListener {
......

SensorManager sensorMan = (SensorManager)getSystemService(SENSOR_SERVICE);
Sensor sensor = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

sensorMan.registerListener(context, sensor,
    SensorManager.SENSOR_DELAY_UI);

@Override
 public void onSensorChanged(SensorEvent event) {

     if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){

      }
     //Or some other sensor.
  }