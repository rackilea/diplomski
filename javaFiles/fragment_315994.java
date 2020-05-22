Timer swipeTimer = new Timer();
 swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                mHandler.post(run);
            }
        }, 500, 500); //put this onCreateView or at initialization