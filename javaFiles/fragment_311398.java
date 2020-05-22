@Override
public void onSensorChanged(SensorEvent event) {

    switch(event.sensor.getType()) {

        case Sensor.TYPE_ACCELEROMETER:
            getAccelerometer(event);
            break;
        case Sensor.TYPE_GRAVITY:
            doSomethingDifferent();
            break;
        }
    }
}