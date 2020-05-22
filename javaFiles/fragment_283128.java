public class SensorActivity extends Activity implements SensorEventListener {

private Sensor mOrientationSensor;

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    SensorManager mSensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
    mOrientationSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
}

@Override
public void onResume() {
    super.onResume();

    if (mSensorManager != null) {
        mSensorManager.registerListener(this, mOrientationSensor, SensorManager.SENSOR_DELAY_UI);
    }

}

@Override
public void onPause() {
    super.onPause();

    mSensorManager.unregisterListener(this, mOrientationSensor);
}


@Override
public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);

        // do something here
}