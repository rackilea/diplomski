public void run() {
    if (mTestMode) {
        double amp = mSensor.getAmplitudeEMA();
        tv.setText(String.valueOf(amp));
    }
}