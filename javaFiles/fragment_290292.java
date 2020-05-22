public void startCountDown() {
    timer.schedule(new TimerTask() {
    @Override
        public void run() {
        Platform.runLater(new Runnable() {
           public void run() {
               countDown--;
                countDownText.setText("Time left:" + countDown);

                if (countDown < 0)
                    timer.cancel();
          }
        });
    }
    }, 1000, 1000); //Every 1 second
}