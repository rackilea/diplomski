public void startTicking() {

        countDownTimer = new CountDownTimer(timerinterval, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onFinish() {
                // TODO Auto-generated method stub
                       db.open();
                String total = currentGame.getRight() + "";
                db.insertOptions(topic1, total, mon);
                db.close();
            }
        };
    }