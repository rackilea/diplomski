private void initialiseCountdownTimer(long timerDuration, long timerInterval){
    countDownTimer = new CountDownTimer(timerDuration, timerInterval) {
        @Override
        public void onTick(long millisUntilFinished) {
            if(!countdownImageStack.empty()){
                countdownImage.setImageResource(countdownImageStack.pop());
                countdownImage.startAnimation(countdownAnimationSet);

            }

        }