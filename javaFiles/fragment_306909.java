mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
        public void onChronometerTick(Chronometer cArg) {
            long t = SystemClock.elapsedRealtime() - cArg.getBase();
            cArg.setText(DateFormat.format("kk:mm:ss:SSS", t));
        }
    });