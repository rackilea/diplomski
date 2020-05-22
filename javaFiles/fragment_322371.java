public void countDown(long time) {
        if (time == 490) {
            return;
        }

        new CountDownTimer(10000, time) {

            public void onTick(long millisUntilFinished) {
                // Do whatever you want
             }

             public void onFinish() {
                 countDown(nextTime); // nextTime can be 700, 100, ... It's up to you. (Your rule). :">
             }

        }.start();

    }