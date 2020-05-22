Handler mHandler = new Handler();
  float lux,conversion;// intialize it
  Runnable run=new Runnable() {

    @Override
    public void run() {

            textLightReading.setText("Light: " + conversion);
            //Line to kill runnable before a new one starts
            mHandler.removeCallbacks(run);

    }
};

  //it will update 1 second after onSensorChanged called and when condition true
  //As per your both attempts
  @Override
public void onSensorChanged(final SensorEvent event) {

if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

     lux = event.values[0];
     conversion = Math.round(((1/638f) * lux) * 100.0f)/100.0f;
    mHandler.postDelayed(run, 1000);

  }
}