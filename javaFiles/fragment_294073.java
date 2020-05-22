int c = -1; // define global

chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
    @Override
    public void onChronometerTick(Chronometer chronometer) {
        c++;
        if(c == 30) {
            c = 0;
            MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.ding);
            mp.start();
        }
    }
});