private void countDown() {
    if (seconds == 0) {
        minutes--;
        seconds = 59;
    } else {
        seconds--;
    }
    defaultTime.setMinutes(minutes);
    defaultTime.setSeconds(seconds);
    timer.setText(defaultTime.toString());
}