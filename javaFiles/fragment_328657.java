bar = (ProgressBar) findViewById(R.id.progress);
    bar.setProgress(total);
    int twoMin = 2 * 60 * 1000; // 2 minutes in milli seconds

    /** CountDownTimer starts with 2 minutes and every onTick is 1 second */
    cdt = new CountDownTimer(twoMin, 1000) { 

        public void onTick(long millisUntilFinished) {

            total = (int) ((dTotal / 120) * 100);
            bar.setProgress(total);
        }

        public void onFinish() {
             // DO something when 2 minutes is up
        }
    }.start();