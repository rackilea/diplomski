@Override
    public void onSensorChanged(SensorEvent event) {

        sendValuesToYourServer(Float.toString(event.values[0]) + "," + Float.toString(event.values[1]) +","+ Float.toString(event.values[2])); 


    }