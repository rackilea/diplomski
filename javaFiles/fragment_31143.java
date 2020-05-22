int startCountdown = 5;
int currentCountdown;
Handler countdownHandler = new Handler();
Timer countdownTimer = new Timer();
public void startCountdownTimer() {
    currentCountdown = startCountdown;
    for (int i = 0; i <= startCountdown; i++) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countdownHandler.post(doA);
            }
        };
        countdownTimer.schedule(task, i * 1000);
    }
}
final Runnable doA = new Runnable() {
    @Override
    public void run() {
        if (currentCountdown != 0) {
            tvTextView.setText("" + currentCountdown);
        currentCountdown--;
        } else {
            currentCountdown = startCountdown;
            startCountdownTimer();
        }
    }
};