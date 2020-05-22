private void setUpPageUpdater() {
    listUpdaterExecuter = new ScheduledThreadPoolExecutor(NUM_LIST_UPDATER_THREADS);
    listUpdaterExecuter.scheduleAtFixedRate(new Runnable() {
        private Runnable update = new Runnable() {
            @Override
            public void run() {
                updateList();
            }
        };

        @Override
        public void run() {
            runOnUiThread(update);
        }
    }, 5, 5, TimeUnit.SECONDS);
}