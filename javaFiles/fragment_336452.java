new CountDownTimer(60**10*1000, 1000) {

                public void onTick(long millisUntilFinished) {
                    time.setText("seconds remaining: "
                            + millisUntilFinished / 1000);


                }

                public void onFinish() {
                    here you write the function to start
                                             button to disable and popup

                }
            }.start();