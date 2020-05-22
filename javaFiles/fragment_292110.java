private Timer timer;

public void progress(final String Percentage){

    donutProgress = (DonutProgress) findViewById(R.id.donut_progress_male);

    if (timer == null) {
        timer = new Timer();
    } else {
        timer.cancel();
    }
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    double d =  Double.parseDouble(Percentage);
                    int i = (int) d;
                    donutProgress.setProgress(0);
                    donutProgress.setProgress(i);


                }
            });
        }
    },1000,100);
}