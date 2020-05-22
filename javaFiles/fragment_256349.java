Timer someTimer= new Timer ();
someTimer.schedule (new TimerTask () {
        @Override
        public void run () {
          // do your Checking here, for toast use runOnUIThread() or handler.

        }
    }, 0, 100);