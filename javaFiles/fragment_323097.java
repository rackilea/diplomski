private CountDownTimer currentCount;
public void Brew(View v) {
    final Button BrewButton = (Button) V;
    final String ButtonText = BrewButton.getText().toString();

    if (ButtonText.equals("Stop Timer!") && currentCount != null) {
        currentCount.cancel();
        currentCount = null;
        BrewButton.setText("Start Brewing!");
        return;
    }

    currentCount = new CountDownTimer(BrewingSeekBar.getProgress() * 1000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
            Long Minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
            Long Seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(Minutes);

            TimerText.setText("" + String.format("%01d:%02d", Minutes, Seconds));

            int VibrateTime = BrewingSeekBar.getProgress() - BloomingSeekBar.getProgress();

            if ((TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)) == VibrateTime) {
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate 500ms
                v.vibrate(500);

                Toast.makeText(MainActivity.this, "Blooming is finnished!", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFinish() {
            TimerText.setText("Finished!");
        }
    };

    currentCount.start();
    BrewButton.setText("Stop Timer!");
}