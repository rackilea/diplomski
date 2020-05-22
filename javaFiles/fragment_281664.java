private void launchOnScrollThread() {
    new Thread() {
        @Override
        public void run() {
            // endless loop - maybe you would like to put some condition to end the loop
            for(;;) {
                ready = true;
                Thread.sleep(100);    // wait here for 100 milliseconds
            }
        }
    }.start();
}