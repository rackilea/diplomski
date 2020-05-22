public class FooTimer extends Activity implements View.OnClickListener {
    private CountDownTimer timer;
    private TextView timerDisplay;
    private Button pauseButton;
    private boolean timerRunning = false;
    private boolean timerDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pauseButton = (Button) findViewById(R.id.pause_button);
        pauseButton.setOnClickListener(this);

        timerDisplay = (TextView) findViewById(R.id.timer_display);
        timerDisplay.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));

        timer = newTimer();
        timerRunning = true;
        timer.start();
    }

    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.pause_button:
            toggleTimer();
            break;
        }
    }

    private void toggleTimer() {
        if (timerRunning) {
            timer.cancel();
            pauseButton.setText(getResources().getString(R.string.resume_label));
            timerRunning = false;
        } else if (timerDone) {
            finishActivity(0);
        } else {
            seconds += 1;
            timer = newTimer();
            timer.start();
            pauseButton.setText(getResources().getString(R.string.pause_label));
            timerRunning = true;
        }
    }

    private CountDownTimer newTimer() {
        millis = (minutes * 60 * 1000) + ((seconds + 1) * 1000);
        return new CountDownTimer(millis, 1000) {
            public void onTick(long millisUntilFinished) {
                timerDisplay.setText(String.format("%d:%02d:%02d", hours, minutes, seconds));
            }

            public void onFinish() {
                timerDisplay.setText("Finished");
                timerRunning = false;
                timerDone = true;
                pauseButton.setText(getResources().getString(R.string.back_label));
            }
        };
    }
}