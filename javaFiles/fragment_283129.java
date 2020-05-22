public class SensorActivity extends Activity implements SensorEventListener {

  private SensorManager mSensorManager;
  private final float[] mAccelerometerReading = new float[3];
  private final float[] mMagnetometerReading = new float[3];

  private final float[] mRotationMatrix = new float[9];
  private final float[] mOrientationAngles = new float[3];

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
  }

  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
    // Do something here if sensor accuracy changes.
    // You must implement this callback in your code.
  }

  @Override
  protected void onResume() {
    super.onResume();

    // Get updates from the accelerometer and magnetometer at a constant rate.
    // To make batch operations more efficient and reduce power consumption,
    // provide support for delaying updates to the application.
    //
    // In this example, the sensor reporting delay is small enough such that
    // the application receives an update before the system checks the sensor
    // readings again.
    mSensorManager.registerListener(this, Sensor.TYPE_ACCELEROMETER,
      SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
    mSensorManager.registerListener(this, Sensor.TYPE_MAGNETIC_FIELD,
      SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
  }

  @Override
  protected void onPause() {
    super.onPause();

    // Don't receive any more updates from either sensor.
    mSensorManager.unregisterListener(this);
  }

  // Get readings from accelerometer and magnetometer. To simplify calculations,
  // consider storing these readings as unit vectors.
  @Override
  public void onSensorChanged(SensorEvent event) {
    if (event.sensor == Sensor.TYPE_ACCELEROMETER) {
      System.arraycopy(event.values, 0, mAccelerometerReading,
        0, mAccelerometerReading.length);
    }
    else if (event.sensor == Sensor.TYPE_MAGNETIC_FIELD) {
      System.arraycopy(event.values, 0, mMagnetometerReading,
        0, mMagnetometerReading.length);
    }
  }

  // Compute the three orientation angles based on the most recent readings from
  // the device's accelerometer and magnetometer.
  public void updateOrientationAngles() {
    // Update rotation matrix, which is needed to update orientation angles.
    mSensorManager.getRotationMatrix(mRotationMatrix, null,
      mAccelerometerReading, mMagnetometerReading);

    // "mRotationMatrix" now has up-to-date information.

    mSensorManager.getOrientation(mRotationMatrix, mOrientationAngles);

    // "mOrientationAngles" now has up-to-date information.
  }
}