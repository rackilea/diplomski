public void callAsynchronousTask() {
    final Handler handler = new Handler();
    Timer timer = new Timer();
    TimerTask doAsynchronousTask = new TimerTask() {       
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {       
                    try {
                        PerformBackgroundTask performBackgroundTask = new PerformBackgroundTask();
                        // PerformBackgroundTask this class is the class that extends AsynchTask 
                        performBackgroundTask.execute();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                    }
                }
            });
        }
    };
    timer.schedule(doAsynchronousTask, 0, 50000); //execute in every 50000 ms
}