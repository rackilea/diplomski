private void CountDown() {

    for (this.minutes = 25; minutes >= 0; minutes--) {
        for (this.seconds = 59; seconds >= 0; seconds--) {
            this.defaultTime.setMinutes(minutes);
            this.defaultTime.setSeconds(seconds);
            timer.setText(defaultTime.toString());
        }
    }

}