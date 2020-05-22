public class yourActivity extends Activity implements SensorEventListener{
 private SensorManager sensorManager;
 double ax,ay,az;   // these are the acceleration in x,y and z axis
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
   }
   @Override
   public void onAccuracyChanged(Sensor arg0, int arg1) {
   }

   @Override
   public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ax=event.values[0];
                    ay=event.values[1];
                    az=event.values[2];
            }
   }
}