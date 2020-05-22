public class AndroidLightSensor implements LightSensorInterface, SensorEventListener {
    private float currentLux = 0;

    @Override
    public float getCurrentLux() {
        return currentLux;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        this.currentLux = event.values[0];
    }
}