btnFirstPlayer.setTag(1); // start timer
btnFirstPlayer.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
         if (btnFirstPlayer.getTag() == 1) {
             startTimer();
         } else {
             stopTimer();
         }
    }); 

private void startTimer() {
    long startTime = firstPlayerRemainingTime;

    btnFirstPlayer.setTag(2); // stop timer
    btnFirstPlayer.setText("Stop");

    mCountDownTimer = new CountDownTimer(firstPlayerRemainingTime, 1000) {
           public void onTick(long millisUntilFinished) {
               firstPlayerRemainingTime = millisUntilFinished;
               tvPlayerOneTimer.setText("" + firstPlayerRemainingTime / 1000)

               // Here you would like to check if 30 seconds has passed
               if ((startTime / 1000) - (limitedTime / 1000) 
                            == (firstPlayerRemainingTime / 1000)) {
                   stopTimer();
               }

               // Here you would like to increase the time of the second player
               secondPlayerRemainingTime = ++1000; 
           }

           public void onFinish() {
               mTextField.setText("done!");
           }

           }.start();
     }
}

private void stopTimer() {
    btnFirstPlayer.setTag(1);
    btnFirstPlayer.setText("Start");
    mCountDownTimer.cancel();

    // I guess here starts second player move

}