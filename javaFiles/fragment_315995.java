Handler mHandler = new Handler();
  Runnable run=new Runnable() {

    @Override
    public void run() {


            textLightReading.setText("Light: " + conversion); //update textView 
              mHandler.postDelayed(run, 1000);
    }
};


              mHandler.post(run); // at initialization or anywhere in your code where you want to start handler

  @Override
public void onSensorChanged(final SensorEvent event) {

if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

     lux = event.values[0];
     conversion = Math.round(((1/638f) * lux) * 100.0f)/100.0f;

  }
}