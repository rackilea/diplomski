public void shotClockStart(View v) {
    Chronometer shotclock = (Chronometer) findViewById(R.id.chrono1);
    shotclock.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
        @Override
        public void onChronometerTick(Chronometer chronometer) {
            long timeElapsed = SystemClock.elapsedRealtime() - chronometer.getBase();
            if (timeElapsed >= 30000) {
                //  HERE I WANT A VIBRATION ON THE DEVICE.
            }else if(timeElapsed>=60000){
                //HERE I WANT A NOTIFICATION ALERT
            }
        }
    });
    shotclock.setBase(SystemClock.elapsedRealtime());
    shotclock.start();
}