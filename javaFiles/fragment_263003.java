void setPost(final Post post) { 

          ...

        long currentTime = date.getTime();
        long endTime = post.getTimerEndDate().getTime();
        long timeLeft = endTime - currentTime;

        if (countdowntimer != null) {
           //there is an existing timer so we cancel it to prevent duplicates
           countdowntimer.cancel();
           }
        countdowntimer = new CountDownTimer(timeLeft, 1000) {

            @SuppressLint("DefaultLocale")
            public void onTick(long millisUntilFinished) {

                timer.setText(String.format("%02d:%02d:%02d",
                        (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24),
                        (int) ((millisUntilFinished / (1000 * 60)) % 60),
                        (int) (millisUntilFinished / 1000) % 60));
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                timer.setText("done!");
            }

        }.start();

  }