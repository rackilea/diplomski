new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                button.setEnabled(false);
                button.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                button.setEnabled(true);
            }
        }.start();